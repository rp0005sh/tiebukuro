import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1行目
        String abr = br.readLine().trim();
        int[] first = java.util.Arrays.stream(abr.split(" ")).mapToInt(Integer::parseInt).toArray();

        // ２行目
        int n = Integer.parseInt(br.readLine().trim());

        // ２行目分ループする
        for (int i = 0; i < n; i++) {

            // ３行目以降
            String basyo = br.readLine().trim();
            int[] basyoSettei = java.util.Arrays.stream(basyo.split(" ")).mapToInt(Integer::parseInt).toArray();

            // 変数を明確にしておく
            int x = basyoSettei[0];
            int y = basyoSettei[1];
            int a = first[0];
            int b = first[1];
            int R = first[2];

            if ((x - a) * (x - a) + (y - b) * (y - b) >= R * R) {
                System.out.println("safe");
            } else {
                System.out.println("danger");
            }
        }
    }
}
