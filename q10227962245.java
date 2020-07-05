import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        int N = 150; // サンプルサイズ
        int k = 15;   // 階級数

        // サンプリングする
        System.out.println("サンプルデータ");
        double[] sample = DoubleStream.generate(Main::rand).limit(N+1)
            .peek(System.out::println).sorted().toArray();
        
        // 階級幅を決める
        double length = (sample[N] - sample[0]) / k;

        // ヒストグラムを作成
        int[] hist = new int[k];
        for (int i = 0; i < N; i++) {
            int index = (int)((sample[i] - sample[0]) / length);
            hist[index]++;
        }

        // 描画
        System.out.println("\nヒストグラム表示");
        for (int i = 0; i < k; i++) System.out.printf("%6.3f～%6.3f|%s%n"
            , sample[0] + length * i
            , sample[0] + length * (i+1)
            , "*".repeat(hist[i]));
    }

    /** パレート分布の乱数を取得する */
    static double rand() {
        return 1 / Math.sqrt(1 - Math.random());
    }
}
