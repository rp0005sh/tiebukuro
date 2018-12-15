class Main {
    public static void main(String[] args) {
        // 第一種完全楕円積分の計算結果を-1～1の範囲で0.1刻みで表示
        System.out.println("第一種完全楕円積分");
        for (int i = 0; i <= 20; i++) {
            double k = i * 0.1 - 1;
            System.out.printf("K(%.2f) = %f%n", k, K(k));
        }

        System.out.println();
        // 第二種完全楕円積分の計算結果を-1～1の範囲で0.1刻みで表示
        System.out.println("第二種完全楕円積分");
        for (int i = 0; i <= 20; i++) {
            double k = i * 0.1 - 1;
            System.out.printf("E(%.1f) = %f%n", k, E(k));
        }
    }

    /**
     * 第一種完全楕円積分(台形近似法)
     * @param k 
     */
    static double K(final double k) {
        final int n = 1000000; // 分割数
        final double dx = Math.PI/2 / n;
        double sum = 0;
        java.util.function.DoubleUnaryOperator f = x -> 1/Math.sqrt(1 - k * k * Math.sin(x) * Math.sin(x));
        for (int i = 0; i < n; i++) {
            sum += (f.applyAsDouble(i * dx) + f.applyAsDouble((i + 1) * dx)) * dx / 2;
        }
        return sum;
    }
    
    /**
     * 第二種完全楕円積分(台形近似法)
     * @param k 
     */
    static double E(final double k) {
        final int n = 1000000; // 分割数
        final double dx = Math.PI/2 / n;
        double sum = 0;
        java.util.function.DoubleUnaryOperator f = x -> Math.sqrt(1 - k * k * Math.sin(x) * Math.sin(x));
        for (int i = 0; i < n; i++) {
            sum += (f.applyAsDouble(i * dx) + f.applyAsDouble((i + 1) * dx)) * dx / 2;
        }
        return sum;
    }
}
