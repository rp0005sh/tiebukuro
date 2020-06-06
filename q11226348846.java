class QuadraticEqn {
    public static void main(String[] srgs) {
        System.out.print("Input a ->");
        double a = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Input b ->");
        double b = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Input c ->");
        double c = new java.util.Scanner(System.in).nextDouble();
        double d = (b * b - 4.0 * a * c);
        
-       // 判別式によって計算方法が変わるから、この段階でx1,x2は計算しない
-       double x1=(-b+Math.sqrt(d))/(2.0*a);
-       double x2=(-b-Math.sqrt(d))/(2.0*a);
        if (d > 0) {
+            // Real rootは、普通に計算する
+            double x1=(-b + Math.sqrt(d)) / (2.0 * a);
+            double x2=(-b - Math.sqrt(d)) / (2.0 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            System.out.println("Real root");
        } else if (d == 0) {
+            // Multiple rootは、判別式が0なので平方根の計算はいらない
+            double x1= -b / (2.0 * a);
+            double x2= x1;

            System.out.println("x1 = "+x1);
            System.out.println("x2 = "+x2);
            System.out.println("Multiple root");
        } else {
+            // Imaginary rootは、複素数は計算できないので、実部・虚部に分けて計算する
+            double real = (-b) / (2.0 * a);            // 実部は共通
+            double imag = (Math.sqrt(-d)) / (2.0 * a); // 虚部も絶対値は同じ（共役）

            System.out.println("x1 = " + real + "+" + imag + "i");
            System.out.println("x2 = " + real + "-" + imag + "i");
            System.out.println("Imaginary root");
        }
    }
}
