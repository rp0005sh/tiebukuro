import java.util.*;

class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ■ 情報入力処理
        // 店舗数入力
        System.out.println("店舗数を入力してください。");
        int n = sc.nextInt();
        // 店舗情報入力
        Shop[] shops = new Shop[n];
        for(int i = 0; i < n;i++) {
            System.out.println(i + "番目の店舗コードを入力してください。");
            String code = sc.next();
            System.out.println(i + "番目の店舗の売上数を入力してください。");
            int sales = sc.nextInt();
            // 配列に格納
            shops[i] = new Shop(code, sales);
        }


        // ■ データをまとめる処理
        // 売上のデータまとめ(合計、平均、最大、最小)
        IntSummaryStatistics summary = Arrays.stream(shops).mapToInt(s -> s.sales).summaryStatistics();
        // 売上平均以上の店舗のみの配列を作る
        Shop[] upper = Arrays.stream(shops).filter(s -> s.sales >= summary.getAverage()).toArray(Shop[]::new);
        // 売上平均未満の店舗のみの配列を作る
        Shop[] lower = Arrays.stream(shops).filter(s -> s.sales < summary.getAverage()).toArray(Shop[]::new);


        // ■ 出力処理
        System.out.println("平均売上数は"+ summary.getAverage() +"です。");
        System.out.println("平均売上数以上の店舗数は"+ upper.length +"です。");
        System.out.println("平均売上数未満の店舗数は"+ lower.length +"です。");
        System.out.println("最高売上数は"+ summary.getMax() +"です。");
        System.out.println("最低売上数は"+ summary.getMin() +"です。");
        for (Shop shop : upper)System.out.println("平均売上数以上の店舗コード" + shop.code + " 売上数 " + shop.sales);
        for (Shop shop : lower)System.out.println("平均売上数未満の店舗コード" + shop.code + " 売上数 " + shop.sales);
    }
}


class Shop {
    /** 店舗コード */
    final String code;
    /** 売上 */
    final int sales;
    /**
     * コンストラクタ
     * @param code 店舗コード
     * @param sales 売上
     */
    Shop(String code, int sales) {this.code = code; this.sales = sales;}
}
