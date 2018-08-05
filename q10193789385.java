import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 入力データ(財布に入っていたレシートの金額)
        int[] receipt = {
            2160, 12940, 13975, 2160, 2160, 330,
            2160, 10000, 5432, 2160, 330, 200,
            128, 360, 1800, 100,2160, 2100, 360, 330 };

        // ベンフォードに変換して、ヒストグラムを作る
        int[] hist = new int[9];
    	IntStream.of(receipt)
            .map(num -> String.valueOf(num).charAt(0) - '0')
            .forEach(num -> hist[num - 1]++);
        showHistogram(hist, 1);

        // 適合度検定でベンフォードの法則に従っているのかチェック
        int sum = IntStream.of(hist).sum();
        double[] model = IntStream.rangeClosed(1, 9)
                .mapToDouble(num -> Math.log10(1 + 1.0 / num) * sum).toArray();
        double value = IntStream.range(0, 9)
                .mapToDouble(n -> (model[n] - hist[n]) * (model[n] - hist[n]) / model[n]).sum();
        System.out.println("カイ二乗値" + value);

        // javaにはカイ二乗分布の確率密度関数を求めるメソッドはないので、分布表より評価
        if (value > 15.5/* 自由度8、有意水準0.05 */) {
            System.out.println("「ベンフォードの法則に従わない」と言える");
        } else {
            System.out.println("「ベンフォードの法則に従わない」とは言えない");
        }
    }

    /**
     * ヒストグラムの表を表示する
     * @param hist 頻度データ
     * @param dx グラフの帯の１メモリの大きさ
     */
    public static void showHistogram(int[] hist, int dx) {
        StringBuilder sb = new StringBuilder("=== ヒストグラム ===");
        sb.append(System.lineSeparator());
        for (int i = 0; i < hist.length; i++) {
            sb.append(i + 1).append(':');
            // 帯を作る
            for (int j = 0; j < hist[i]; j += dx) sb.append('■');

            // 一応、帯の末尾に頻度の数を表示させておく
            sb.append('(').append(hist[i]).append(')');
            sb.append(System.lineSeparator());
        }
        sb.append("===============");
        System.out.println(sb.toString());
    }
}
