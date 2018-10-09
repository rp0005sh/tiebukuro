import java.util.Map;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        // 集計結果格納Map
        Map<String, int[]> map = new HashMap<>();

        // ファイル読み込んで、1行ずつ処理
        for (String line : Files.readAllLines(Paths.get("data.csv"))) {
            // 1行の文字列をカンマ区切りで分ける(配列化)
            String[] tmp = line.split(",");

            // キー登録されてなければ全て0の集計データを設定
            if(!map.containsKey(tmp[0])) map.put(tmp[0], new int[]{0, 0});

            // マップから集計データを取得
            int[] sum = map.get(tmp[0]);

            // データを加算
            sum[0] += Integer.parseInt(tmp[1]);
            sum[1] += Integer.parseInt(tmp[2]);
        }

        // 集計データの出力
        for (Map.Entry<String, int[]> e : map.entrySet()) {
            String group = e.getKey();
            int sum1 = e.getValue()[0];
            int sum2 = e.getValue()[1];
            System.out.println(group + "," + sum1 + "," + sum2);
        }
    }
}
