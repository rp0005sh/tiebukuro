class QuadraricEqn {
  public static void main(String[] args) {
    double a, b, c;
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String result;

    // 各数値パラメータ入力
    System.out.print("Intput a →");
    a = sc.nextDouble();
    
    System.out.print("Intput b →");
    b = sc.nextDouble();
    
    System.out.print("Intput c →");
    c = sc.nextDouble();
    
    // 判別式Dを求める
    double D = b * b - 4 * a * c;

    // 実数解(Real root)
    if (D > 0) {
        result = String.format("x1 = %f%nx2 = %f%nReal root",
            (-b + Math.sqrt(D)) / (2 * a), // x1
            (-b - Math.sqrt(D)) / (2 * a));// x2
    }

    // 重解(Multiple root)
    else if(D == 0) {
        result = String.format("x1 = %f%nMultiple root",
            -b / (2 * a));// x
    }

    // 虚数解(Imaginary root)
    else {
        result = String.format("x1 = %f + %fi%nx2 = %f - %fi%nImaginary root",
            -b / (2 * a), Math.sqrt(-D)/(2 * a), // x1
            -b / (2 * a), Math.sqrt(-D)/(2 * a));// x2
    }
    System.out.println(result);
  }
}
