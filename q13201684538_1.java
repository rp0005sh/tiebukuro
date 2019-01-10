class Main {
    public static void main(String[] args) {
        long n = 100000000;
        double dx = 5.0 / n;

        // 面積を求める
        double S = 0;
        for (long i = 0; i < n; i++) {
            S += f(i * dx) * dx;
        }
        System.out.println("面積：" + S * 4);

        // 円周を求める
        double L = 0;
        for (long i = 0; i < n; i++) {
            L += g(i * dx) * dx;
        }
        System.out.println("円周 : " + L * 4);
    }

    /** 第一像限の円の関数 */
    static double f(double x) {
        return Math.sqrt(25 - x * x);
    }

    /** 第一像限の円周を求める関数 */
    static double g(double x) {
        return Math.sqrt(1 + x * x / (25 - x * x));
    }
}
