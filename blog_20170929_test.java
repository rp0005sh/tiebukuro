/** 
 * Stream<Integer>に変換してComparatorを使って降順ソート
 */
class Main1 {
    public static void main(String[] args) {
        // 計測開始
        long start = System.currentTimeMillis();

        int[] arr = java.util.stream.IntStream.range(0, 50000000)
            .boxed().sorted(java.util.Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();

        // 計測完了
        long end = System.currentTimeMillis();
        System.out.println("かかった時間:" + (end - start) + "[msec]");
    }
}

/** 
 * IntStreamのまま降順ソート
 */
class Main2 {
    public static void main(String[] args) {
        // 計測開始
        long start = System.currentTimeMillis();

        int[] arr = java.util.stream.IntStream.range(0, 50000000)
            .map(n -> -n).sorted().map(n -> -n).toArray();

        // 計測完了
        long end = System.currentTimeMillis();
        System.out.println("かかった時間:" + (end - start) + "[msec]");
    }
}
