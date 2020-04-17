class Main {

    public static void main(String[] args) {
        // 入力処理
        System.out.print("サイコロ振る回数 > ");
        int n = new java.util.Scanner(System.in).nextInt();

        // 合計値を入れる箱を用意
        int sum = 0;

        // サイコロを入力回数だけ振る
        for (int i = 0; i < n; i++) {
            // 賽の目を決定
            int dice = (int)(Math.random() * 6) + 1;
            System.out.println("出目:" + dice);

            // 合計値に足していく
            sum += dice;
        }
        
        // 結果
        System.out.println("合計:" + sum);

        // 奇数かチェックして表示
        if (sum % 2 == 1) System.out.println("奇数です");
    }
}
