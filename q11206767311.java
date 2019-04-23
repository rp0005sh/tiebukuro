class Main {
    public static void main(String[] args) {
        // 文字列配列から数値配列に変換
        int[] arr = java.util.Arrays.stream(args).mapToInt(Integer::parseInt).toArray();

        // 値の範囲は-100~100であるか
        if (java.util.Arrays.stream(arr).anyMatch(n -> n < -100 || 100 < n)) {
            System.out.println("エラー: 数値は -100~100の範囲の整数で入力してください。");
            System.exit(0);
        } else

        // 引数の個数は1個以上であるか
        if (arr.length == 0) {
            System.out.println("エラー: 引数がありません。");
            System.exit(0);
        } else

        // 引数の個数は10個以下であるか
        if (arr.length > 10) {
            System.out.println("エラー: 引数が10個を超えています。");
            System.exit(0);
        }

        // ソートして表示する
        int[] sort;
        System.out.print("昇順: ");
        sort= java.util.Arrays.stream(arr).sorted().toArray();
        System.out.println(java.util.Arrays.toString(sort).replaceAll("[\\[\\],]",""));

        System.out.print("降順: ");
        sort= java.util.Arrays.stream(arr).map(n -> -n).sorted().map(n -> -n).toArray();
        System.out.println(java.util.Arrays.toString(sort).replaceAll("[\\[\\],]",""));
    }
}
