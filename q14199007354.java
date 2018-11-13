public class Main {
    public static void main(String[] args) {
        // 入力処理
        System.out.print("ピラミッドを表示します。段数は？：");
        int n = new java.util.Scanner(System.in).nextInt();

        // 表示処理
        for (int i = 0; i < n; i++) {
            //  n-i 個の半角空白を表示
            for (int j = 0; j < n - i; j++) System.out.print(" ");

            //  2*i-1 個の「i%10」を表示
            for (int j = 0; j < 2 * i - 1; j++) System.out.print(i % 10);

            // 改行挿入
            System.out.println();
        }
    }
}
