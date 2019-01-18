class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // 店舗数入力
        System.out.println("店舗数を入力してください。");
        int n = sc.nextInt();
        // 店舗コード配列
        String StoreCode[] = new String[n];
        // 店舗売上配列
        int Store[] = new int[n];
        // 各店舗情報入力
        for(int i = 0; i < n; i++) {
            System.out.println(i + 1 + "番目の店舗コードを入力してください。");
            StoreCode[i] = sc.next();
            System.out.println(i + 1 + "番目の店舗の売上数を入力してください。");
            Store[i] = sc.nextInt();
        }

        // 平均
        double ave = 0;
        for (int s : Store) ave += s; ave /= n;
        System.out.println("平均売上数は"+ ave +"です。");

        // 平均売上数以上の店舗数
        int upper = 0;
        for (int s : Store) if(s >= ave) upper++;
        System.out.println("平均売上数以上の店舗数は"+ upper +"です。");

        // 平均売上数未満の店舗数
        int lower = n - upper;
        System.out.println("平均売上数以上の店舗数は"+ lower +"です。");

        // 最高売上数
        int max = Store[0];
        for (int s : Store) max = (max > s) ? max : s;
        System.out.println("最高売上数は"+ max +"です。");

        // 最低売上数
        int min = Store[0];
        for (int s : Store) min = (min < s) ? min : s;
        System.out.println("最低売上数は"+ min +"です。");

        // 平均売上数以上の店舗情報一覧
        for (int i = 0; i < n; i++)
            if(Store[i] >= ave)System.out.printf("平均売上数以上の店舗コード%s 売上数 %d%n", StoreCode[i], Store[i]);

        // 平均売上数未満の店舗情報一覧
        for (int i = 0; i < n; i++)
            if(Store[i] < ave)System.out.printf("平均売上数未満の店舗コード%s 売上数 %d%n", StoreCode[i], Store[i]);
    }
}
