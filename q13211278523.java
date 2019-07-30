class Main {
    public static void main(String args[]) {
        // ax^2 + bx + c = 0の形で、a,b,cの定数を決める
        double a, b, c;

        // x^2 - 5x + 6 = 0を想定
        a = 1;
        b = -5;
        c = 6;

        // 判別式を用いて、「２つの異なる実数解を持つ」を判断
        double D = b * b - 4 * a * c;
        if (D > 0) {
            // 二次方程式の解の公式より、解を求める
            double x1 = (-b - Math.sqrt(D))/(2 * a);
            double x2 = (-b + Math.sqrt(D))/(2 * a);
            System.out.println("x = " + x1 + ", " + x2);

        } else {
            System.out.println("２つの異なる実数解を持ちません");
        }
    }
}
