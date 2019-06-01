import java.util.Arrays;
import java.util.Random;

public class Main {
    // 定数を設定しとく
    /** 席数 */
    static final int SIZE = 8;

    /** 計測時間[秒] */
    static final int TEST_TIME = 60 * 60;

    /** 客の滞在時間[秒] */
    static final int STAY_TIME =  17* 60;
    
    /** 10分あたりの来客数(3 ~ 10) */
    static final int VISITORS =  5;

    public static void main(String[] args) {
        // ランダムに来客数を設定
        int[] rnd = new Random().ints(VISITORS * TEST_TIME/600, 0, TEST_TIME).sorted().toArray();
        System.out.println("来客数:" + rnd.length + ", 時間" + Arrays.toString(rnd));

        // カウンターに座ってる客の滞在時間管理
        int[] counter = new int[SIZE];

        // 待ち行列
        int length = 0;

        // 一秒周期での計測
        for (int time = 0; time < TEST_TIME; time++) {
            // 来訪者チェック 
            int t = time;
            if (Arrays.stream(rnd).anyMatch(n -> n == t)) length++;

            // 座席、待ち行列の更新
            for(int i = 0; i < SIZE; i++) {
                // カンター席の奴らの滞在時間を減らす
                if(counter[i] > 0)counter[i]--;

                // 待ってる人がいれば、入店させてやる
                if(counter[i]==0 && length > 0) {
                    length--;
                    counter[i] = STAY_TIME;
                }
            }

            //全て更新後、待ち行列数を出力
            System.out.println(time + "," + length);
        }
    }

}
