class Main {
    public static void main(String[] args) {
        // x方向の半径A、y方向の半径B、分割数Nを決める
        int A = 5, B = 3, N = 100;

        double S = 0, dx = (double)A / N;
        for(int i = 0; i < N;i++) {
            double x = i * dx;
            S += Math.sqrt(B * B - B * B * x * x / (A * A)) *dx;
        }
        S *= 4;

        System.out.println("数値解 S = " + S);
        System.out.println("解析解 S = " + Math.PI * A * B);
    }
}
