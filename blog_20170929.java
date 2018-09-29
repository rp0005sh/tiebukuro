class Main {
    public static void main(String[] args) {
        int[] arr = java.util.stream.IntStream.of(3, 2, 4, 5, 2, 14, 5, 6) // ストリーム作る
            .map(n -> -n) // 符号反転
            .sorted()     // 昇順ソート
            .map(n -> -n) // 符号反転(元に戻す)
            .toArray();   // 配列化

        // 結果出力
        System.out.println(java.util.Arrays.toString(arr));
    }
}
