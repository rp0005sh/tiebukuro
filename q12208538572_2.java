import java.util.Arrays;
import java.util.Random;

public class Main {
    // 定数を設定しとく
    /** 席数 */
    static final int SIZE = 8;

    /** 計測時間[秒] */
    static final int TEST_TIME = 60 * 60;

    /** 客の滞在時間[秒] */
    static final int STAY_TIME = 17 * 60;
    
    /** 10分あたりの来客数(3 ~ 10) */
    static final int VISITORS =  5;

    public static void main(String[] args) {

        // 乱数の種を用いる記載があるので、とりあえす出力結果が毎回同じになるように種を適当に定義
        int[] seed = {
             146542,  172954,  722272, 2066861, 2119076, 2845391, 2853715, 2915626, 2973258, 3407168,
            3701565, 3784589, 4098774, 4399689, 5752832, 5940476, 6451291, 6508733, 6723515, 7137103,
            7150971, 7628226, 7936091, 8089089, 8388978, 8956364, 9196773, 9294119, 9365089, 9530231};

        /*
            配列は、こういうテーブル
           +--------+-----+-----+-----+-----+------+
           |        |1回目|2回目|3回目|・・ |30回目|
           +--------+-----+-----+-----+-----+------+
           |11:50:00|     |     |     |・・ |      |
           +--------+-----+-----+-----+-----+------+
           |11:50:01|     |     |     |・・ |      |
           +--------+-----+-----+-----+-----+------+
           |11:50:02|     |     |     |・・ |      |
           +--------+-----+-----+-----+-----+------+
           |    :   |  :  |  :  |  :  |  :  |  :   |
           +--------+-----+-----+-----+-----+------+
           |13:59:59|     |     |     |・・ |      |
           +--------+-----+-----+-----+-----+------+
        */
        int[][] result = new int[10*60 + TEST_TIME + 60*60][seed.length];

        // 30回試行の為のループ
        for(int count = 0; count < seed.length; count++) {
            // 種で乱数ジェネレータ生成
            Random r = new Random(seed[count]);

            // ランダムに来客数を設定(10分前から計測が始まるので、全体的に10＊60[sec]加算した乱数を作る)
            int[] rnd = r.ints(VISITORS * TEST_TIME/600, 0, TEST_TIME).map(n -> n + 10 * 60).toArray();
            System.out.println("来客数:" + rnd.length + ", 時間" + Arrays.toString(rnd));

            // カウンターに座ってる客の滞在時間管理
            int[] counter = new int[SIZE];

            // 待ち行列
            int length = 0;

            // 一秒周期での計測
            for (int time = 0; time < result.length; time++) {
                // 来訪者チェック 
                int t = time;
                if (Arrays.stream(rnd).anyMatch(n -> n == t)) length++;

                // 座席、待ち行列の更新
                for(int i = 0; i < SIZE; i++) {
                    // カンター席の奴らの滞在時間を減らす
                    if(counter[i] > 0)counter[i]--;

                    // カウンターが開いていて、待ってる人がいれば、入店させてやる
                    if(counter[i] == 0 && length > 0) {
                        length--;
                        counter[i] = r.nextInt(14 * 60) + 10 * 60; // 10～24分間の乱数(sec)
                    }
                }
                //全て更新後、待ち行列数を出力
                result[time][count] = length;
            }
        }

        // シミュレーション結果の出力
        for(int i = 0;i < result.length; i++) {
            // 時間の表示
            // System.out.print(i + ", "); //11：50を基準にカウント表記
            System.out.print(java.time.LocalTime.of(11,50,00).plusSeconds(i) + ", ");//11：50を基準に時刻表記

            // 各試行分も出力(いらなければ、このループ分を削除すればいい)
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ", ");
            }

            // 各時刻ごとの平均値
            System.out.println(Arrays.stream(result[i]).average().getAsDouble());
        }
    }

}
