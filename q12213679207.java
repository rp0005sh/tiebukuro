import java.util.Arrays;

class Main {
    public static void main(String args[]) {

        // 入力処理
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[][] input = new int[5][5];
        for (int[] row : input) {
            for(int i = 0; i < row.length;i++) {
                row[i] = sc.nextInt();
            }
        }
        
        // 出力処理
        System.out.println("実行結果");
        for (int[] row : input) {
            //出力用に並び替えする変数
            String[] result;

            //入力データをそのまま出力
            result = Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new);
            System.out.println("入力データ・" + String.join(" ", result));

            //昇順で並び替え
            result = Arrays.stream(row).sorted().mapToObj(String::valueOf).toArray(String[]::new);
            System.out.println("小さい順・" + String.join(" ", result));

            //降順で並び替え
            result = Arrays.stream(row).map(n->-n).sorted().map(n->-n).mapToObj(String::valueOf).toArray(String[]::new);
            System.out.println("大きい順・" + String.join(" ", result));
        }
    }
}
