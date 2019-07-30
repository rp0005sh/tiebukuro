/** 計算クラス */
class NumberControl {
    /**
     * 引数で渡された二つの整数を比較して大きいほうを戻す
     * @param a 比較対象の整数
     * @param b 比較対象の整数
     * @return result 引数の大きい方の整数
     */
    static int selectMax(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * 引数が三つの場合でも対応
     * @param a 比較対象の整数
     * @param b 比較対象の整数
     * @param c 比較対象の整数
     * @return result 引数のうち一番大きい整数
     */
    static int selectMax(int a, int b, int c) {
        return selectMax(selectMax(a, b), c);
    }
}

/** メインの実行クラス */
class Run5 {
    public static void main(String args[]) {
        // 引数2個の場合の評価
        System.out.println(NumberControl.selectMax(-10, 120));
        System.out.println(NumberControl.selectMax(300, 150));

        // 引数3個の場合の評価
        System.out.println(NumberControl.selectMax(1, 1, 1));
        System.out.println(NumberControl.selectMax(2, 1, 1));
        System.out.println(NumberControl.selectMax(2, 3, 1));
        System.out.println(NumberControl.selectMax(2, 3, 4));
    }
}
