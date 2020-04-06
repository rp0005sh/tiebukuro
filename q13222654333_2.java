class Main {
    public static void main(String[] args) {
        double calc;

        // 1 + 2の計算
        calc = calcPuls(1, 2);
        System.out.println("1 + 2 = " + calc);

        // 1 * 2 * 3 * 4 * 5の計算
        calc = calcMultiplication(1, 2, 3, 4, 5);
        System.out.println("1 * 2 * 3 * 4 * 5 = " + calc);

        // (1 + 2) * 3 / 3の計算
        calc = calcPuls(1, 2);
        calc = calcMultiplication(calc, 3);
        calc = calcDivision(calc, 3);
        System.out.println("(1 + 2) * 3 / 3 = " + calc);
    }

    /**
     * 与えられた引数を利用して、足し算を行う
     * @param base 足し算に使用する数字
     * @param nums 足し算に使用する数字
     * @return 足し算の計算結果
     */
    static double calcPuls(double base, double... nums) {
        double calc = base;
        for (double d : nums) calc += d;
        return calc;
    }

    /**
     * 与えられた引数を利用して、引き算を行う
     * @param base 引き算に使用する数字
     * @param nums 引き算に使用する数字
     * @return 引き算の計算結果
     */
    static double calcMinus(double base, double... nums) {
        double calc = base;
        for (double d : nums) calc -= d;
        return calc;
    }

    /**
     * 与えられた引数を利用して、かけ算を行う
     * @param base かけ算に使用する数字
     * @param nums かけ算に使用する数字
     * @return かけ算の計算結果
     */
    public static double calcMultiplication(double base, double... nums) {
        double calc = base;
        for (double d : nums) calc *= d;
        return calc;
    }

    /**
     * 与えられた引数を利用して、割算を行う
     * @param base 割算に使用する数字
     * @param nums 割算に使用する数字
     * @return 割算の計算結果
     */
    public static double calcDivision(double base, double... nums) {
        double calc = base;
        for (double d : nums) calc /= d;
        return calc;
    }
}
