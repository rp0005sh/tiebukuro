class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // 1回目の入力。この値で、最大値、最小値の初期化を行う
        System.out.println("整数を入力してください");
        int in = sc.nextInt(),
        max = in, min = in, sum = in, count;

        // 一回目の入力で「-1」が入れられたら計算不可なので何もせず終了
        if (in == -1) {
            System.out.println("入力された値はありません");
            return;
        }

        // 二回目以降の入力処理は「-1」が入力されるまで繰り返す
        for (count = 1; true; count++) {

            // 入力処理
            System.out.println("整数を入力してください");
            in = sc.nextInt();

            // 更新処理
            if (in == -1) break;    // -1の入力なら終了
            if (max < in) max = in; // 最大値より上の値が入力されたら最大値を更新
            if (min > in) min = in; // 最小値より下の値が入力されたら最小値を更新
            sum += in;              // 合計値は常に加算
        }

        // 出力処理
        System.out.println("入力された整数の最大は" + max);
        System.out.println("入力された整数の最小は" + min);
        System.out.println("入力された整数の平均は" + (double)sum / count);
    }
}
