class Main {
    public static void main(String[] args) {
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
