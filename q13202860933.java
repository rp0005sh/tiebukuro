class Main {
    public static void main(String[] args) {
        // 入力処理
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("商品金額入力 > ");
        int item = sc.nextInt();
        System.out.print("支払金額入力 > ");
        int money = sc.nextInt();

        // お金が足りなければ不正終了
        if (money < item) throw new RuntimeException("支払額が" + (item - money) + "円足りません");

        // お金の種類
        int[] type = {10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1};
        // 各金種の枚数を計算して、表示
        for (int i = 0, tmp = money - item; i < type.length; tmp %= type[i++]) {
            System.out.printf("%5d円は%d枚%n", type[i], (tmp / type[i]));
        }
    }
}
