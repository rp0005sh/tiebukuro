public class Main {
    public static void main(String[] args) {

        double a[][] ={
            { 2.0, 1.0, 3.0, 4.0},
            { 3.0, 2.0, 5.0, 2.0},
            { 3.0, 4.0, 1.0,-1.0},
            {-1.0,-3.0, 1.0, 3.0},
        };

        double b[][] = {
            {1},
            {-1},
            {3},
            {-2},
        };
        
        // 掛け算
        double c[][] = multiply(a, b);

        // 表示
        showMatrix(c);
    }

    /**
     * A×Bの行列の掛け算
     * @param a 行列A
     * @param b 行列B
     * @return c 行列C(掛け算の結果)
     */
    public static double[][] multiply(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for(int y = 0; y < c.length; y++) {
            for(int x = 0; x < c[0].length; x++) {
                double tmp = 0;
                for(int i = 0; i < a[0].length; i++) tmp += a[y][i] * b[i][x];
                c[y][x] = tmp;
            }
        }
        return c;
    }

    /**
     * 行列の表示
     * @param matrix 表示対象の行列
     */
    public static void showMatrix(double[][] matrix) {
        for (double[] low : matrix) System.out.println(java.util.Arrays.toString(low));
    }
}
