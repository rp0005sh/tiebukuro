class Main {
    public static void main(String[] args) {
        // サイコロを振る回数はランダム（ユーザが指定できる。）
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("サイコロ振る回数を指定 > ");
        final int n = sc.nextInt();

        // サイコロの記録配列を作る
        int dice[][] = new int[n][2]; // サイコロは二個あるので

        // サイコロを指定回数振る
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < n; i++) {
            dice[i][0] = r.nextInt(6) + 1; // 一個目の賽の目(乱数)
            dice[i][1] = r.nextInt(6) + 1; // 二個目の賽の目(乱数)
        }

        // 出た目の合計
        for (int i = 0; i < n; i++) {
            int sum = dice[i][0] + dice[i][1];
            System.out.println(i+1 + "回目の出目の合計:" + sum);
        }

        // 出目の割合《出目の回数÷（ユーザが入力した試行回数）》
        // まず、全部の出目の回数をカウント
        int[] hist = new int[6];
        for (int i = 0; i < n; i++) {
            hist[dice[i][0] - 1]++;
            hist[dice[i][1] - 1]++;
        }
        // 各目の割合を表示
        for (int i = 0; i < 6; i++) {
            System.out.println(i + 1 + "の目の割合:" + (float)hist[i] / n);
        }

        // 総和の出目,2〜12
        int sum = 0;
        for(int i = 0; i < 6; i++) sum += (i + 1) * hist[i];
        System.out.println("総和:" + sum);
    }
}
