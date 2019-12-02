class Main {
    public static void main(String[] args) {

        // 点数を入力していき，マイナスの値が入力されたらデータ入力を終了
        java.util.List<Integer> list = new java.util.ArrayList<>();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        for (int n;(n = sc.nextInt()) >= 0; list.add(n));

        // 平均、分散、標準偏差を求める
        final double ave = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        final double var = list.stream().mapToDouble(n -> n - ave).map(d -> d * d).average().orElse(0);
        final double sd = Math.sqrt(var);

        // 結果
        System.out.println("------- 結果 ---------");
        System.out.printf("平均:%.3f%n", ave);
        System.out.printf("標準偏差:%.3f%n", sd);
        System.out.println("偏差値");
        list.stream().forEach(n -> System.out.printf("%d -> %.3f%n", n, (n - ave) / sd));
    }
}
