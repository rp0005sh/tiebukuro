import java.util.stream.IntStream;
import java.math.BigInteger;
import java.util.regex.*;
import java.util.*;

public class Main {
    /** ノーツ数 */
    static int N = 100;

    public static void main(String[] args) {
        // 入力された得点になるノーツの組み合わせが存在するかチェックするフラグ
        boolean ok = false;

        // 入力
        System.out.print("出したいスコア > ");
        long n = new java.util.Scanner(System.in).nextInt();

        // ノーツの全組み合わせをチェック
        BigInteger num;
        for (num = BigInteger.ZERO; check(num); num = num.add(BigInteger.ONE)) {
            long score = score(create(num));
            if (ok = (n == score)) break;
        }

        // 結果の出力
        System.out.println((ok) ?
                String.format("%" + N + "s", num.toString(2)).replace(" ","0")
                : "組み合わせはありません");
    }

    /** コンボの正規表現 */
    static final Pattern PATTERN = Pattern.compile("1+");

    /**
     * コンボ数の配列を作る
     * @param num 組み合わせパターン
     * @return コンボ数の配列
     */
    static int[] create(BigInteger num) {
        List<Integer> k = new ArrayList<>();
        Matcher m = PATTERN.matcher(num.toString(2));
        while (m.find()) k.add(m.group().length());
        return k.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 引数の数値が存在するノーツの組み合わせなのかチェック
     * @param num チェック対象
     * @return true:存在する組み合わせ, false:存在しない組み合わせ
     */
    static boolean check(BigInteger num) {
        return num.toString(2).length() <= N;
    }

    /**
     * スコアを計算する
     * @param k コンボ数群
     * @return スコア値
     */
    static long score(int[] k) {
        long sum1 = IntStream.of(k).sum() * 900_000L;
        long sum2 = IntStream.of(k).map(n -> n * (n + 1)).sum() * 100_000L /(N + 1) ;
        return (sum1 + sum2) / N;
    }
}
