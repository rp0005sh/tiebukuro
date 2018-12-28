A import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        int n = 5, m = 4;
        String cardr[] = new String[m * n];

        // 表示
        System.out.println(java.util.stream.IntStream.range(0, n).mapToObj(num -> " " + (1+num)).collect(java.util.stream.Collectors.joining()));
        for (int i = 0; i < cardr.length; i++) {
            if (i % n == 0) System.out.print(i / n + 1);
            cardr[i] = "□";
            System.out.print(cardr[i]);
            if ((i + 1) % n == 0) System.out.println();
        }

        // 入力要求
        Scanner sc = new Scanner(System.in);
        System.out.print("縦の番号を入力して1～" + m + ">");
        int y = sc.nextInt();
        System.out.print("横の番号を入力して1～" + n + ">");
        int x = sc.nextInt();

        // 入力値のチェック
        if      (y < 1 || m < y) System.out.println("縦の番号が不正");
        else if (x < 1 || n < x) System.out.println("横の番号が不正");
        else
        {// 入力値が正常の場合
            System.out.printf("縦%d横%dを入力しました%n", y, x);

            // 書き換え
            cardr[(x - 1) + n * (y - 1)] = "■";

            // 結果の表示
            for (int i = 0; i < cardr.length; i++) {
                System.out.print(cardr[i]);
                if ((i + 1) % n == 0) System.out.println();
            }
        }
    }
}
