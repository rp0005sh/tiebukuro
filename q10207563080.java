import java.time.Month;
import java.util.Arrays;

import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.US;

class Main {
    public static void main(String[] args) {
        // 各月の配列を作る
        String[] month = Arrays.stream(Month.values())
        .map(m -> m.getDisplayName(SHORT, US))
        .toArray(String[]::new);

        // 数値を入力させて、月を表示せる
        System.out.print("数値入力 > ");
        int num = new java.util.Scanner(System.in).nextInt();
        System.out.println(num + ":" + month[num - 1]);

        // 全月を表示せる
        System.out.println("全月を表示せる");
        for (int i = 0; i < month.length; i++)
            System.out.println((i + 1) + ":" + month[i]);
    }
}
