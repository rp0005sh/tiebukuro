public class Main {
    public static void main(String args[]) {
        // １，２，を満たす配列を生成
        int[] arr = java.util.stream.IntStream
            // 1から200までの数値を生成
            . rangeClosed(1, 200)
            // 配列にする
            .toArray();

        // ３の条件文をオブジェクト化
        java.util.function.IntPredicate check1, check2;
        // 数字の2か4で割り切れる
        check1 =  n -> n % 2 == 0 || n % 4 == 0;
        // 2か4が一つでも数値に含まれている
        check2 =  n -> String.valueOf(n).matches(".*[24].*");

        // マスク(上限値200をマスクできる大きさ(三文字)で作っておく
        final String mask = "XXX";

        java.util.Arrays.stream(arr)
        //４，条件式
        .mapToObj(n -> (check1).or(check2).test(n)
            // 上記の条件で当てはまった数値を「すべての桁数」別の文字列でマスキング
            ? mask.substring(0, String.valueOf(n).length())
            // 条件に当てはまらない数値は普通に文字列に変換
            : String.valueOf(n))

        // ５，最後、マスキングありなしのすべての文字列を順番に表示
        .forEach(System.out::println);
    }
}
