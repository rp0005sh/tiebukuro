import java.util.function.DoubleUnaryOperator;

class  Main {
    public static void main(String[] args) {
        // kとnの定義
        int k = 3, n = 7;
        // A(x)の定義
        DoubleUnaryOperator A = x -> 1 + 7 * x * x * x * x;
        // A'(x)の定義
        DoubleUnaryOperator A_dash = x -> Math.pow(2, -k) * Math.pow(1 + x, n) * A.applyAsDouble((1 - x)/(1 + x));

        // 試しにいくつか計算
        for (int i = 0; i <= 10; i++) {
            float x = i * 0.1f;
            double calc = A_dash.applyAsDouble(x);
            System.out.printf("A'(%.2f) = %f%n", x, calc);
        }
    }
}
