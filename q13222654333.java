class Main {
    public static void main(String[] args) {
        double calc;

        // 1 + 2の計算
        calc = calcPuls(1, 2);
        System.out.println("1 + 2 = " + calc);

        // 1 * 2 * 3 * 4 * 5の計算
        calc = 1;
        for (int i = 1; i <= 5; i++ )
            calc = calcMultiplication(calc , i);
        System.out.println("1 * 2 * 3 * 4 * 5 = " + calc);

        // (1 + 2) * 3 / 3の計算
        calc = calcPuls(1, 2);
        calc = calcMultiplication(calc, 3);
        calc = calcDivision(calc, 3);
        System.out.println("(1 + 2) * 3 / 3 = " + calc);
    }

    /**
     * 与えられた引数を利用して、足し算を行う
     * @param a 足し算に使用する数字
     * @param b 足し算に使用する数字
     * @return 足し算の計算結果
     */
    static double calcPuls(double a, double b) {
        return a + b;
    }

    /**
     * 与えられた引数を利用して、引き算を行う
     * @param a 引き算に使用する数字
     * @param b 引き算に使用する数字
     * @return 引き算の計算結果
     */
    static double calcMinus(double a, double b) {
        return a - b;
    }

    /**
     * 与えられた引数を利用して、かけ算を行う
     * @param a かけ算に使用する数字
     * @param b かけ算に使用する数字
     * @return かけ算の計算結果
     */
    public static double calcMultiplication(double a, double b) {
        return a * b;
    }

    /**
     * 与えられた引数を利用して、割算を行う
     * @param a 割算に使用する数字
     * @param b 割算に使用する数字
     * @return 割算の計算結果
     */
    public static double calcDivision(double a, double b) {
        return a / b;
    }
}
