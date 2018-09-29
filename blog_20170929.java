class Main {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, -5, -2, 14, 5, 6, 4};
        arr = java.util.Arrays.stream(arr) // ストリーム作る
            .map(n -> -n) // 符号反転
            .sorted()     // 昇順ソート
            .map(n -> -n) // 符号反転(元に戻す)
            .toArray();   // 配列化

        // 結果出力
        System.out.println(java.util.Arrays.toString(arr));
        // 結果：[14, 6, 5, 4, 4, 3, 2, -2, -5]になった！成功！
    }
}
