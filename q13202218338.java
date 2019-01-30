class Main {
    public static void main(String[] args) {
        // ax^3 + bx^2 + cx + d = 0
        double a, b, c, d;
        a = 1;
        b = 2;
        c = 2;
        d = 0;

        // 正規化
        b /= a;
        c /= a;
        d /= a;

        // 立体完成(X^3 + pX + q = 0)
        double p = c - b * b / 3; 
        double q = d - b * b * b / 27 - p * b / 3;

        // X = u + vとおき、自由度１増やして変形。u^3の二次方程式を解く
        double D = q * q / 4 + p * p * p / 27;
        Complex u3 = (D >= 0) ? new Complex(-q/2 + Math.sqrt(D), 0) : new Complex(-q/2, Math.sqrt(-D));
        Complex v3 = (D >= 0) ? new Complex(-q/2 - Math.sqrt(D), 0) : new Complex(-q/2, - Math.sqrt(-D));

        // 3乗根を取る
        double r_u = Math.pow(Math.sqrt(u3.real * u3.real + u3.imag * u3.imag), 1/3d);
        double theta_u = Math.atan2(u3.imag, u3.real) / 3;

        Complex[] u = {
            new Complex(r_u * Math.cos(theta_u + Math.toRadians(   0)), r_u * Math.sin(theta_u + Math.toRadians(   0))),
            new Complex(r_u * Math.cos(theta_u + Math.toRadians( 120)), r_u * Math.sin(theta_u + Math.toRadians( 120))),
            new Complex(r_u * Math.cos(theta_u + Math.toRadians(-120)), r_u * Math.sin(theta_u + Math.toRadians(-120)))
        };

        // 3乗根を取る
        double r_v = Math.pow(Math.sqrt(v3.real * v3.real + v3.imag * v3.imag), 1/3d);
        double theta_v = -theta_u;
        Complex[] v = {
            new Complex(r_v * Math.cos(theta_v + Math.toRadians(   0)), r_v * Math.sin(theta_v + Math.toRadians(   0))),
            new Complex(r_v * Math.cos(theta_v + Math.toRadians(-120)), r_v * Math.sin(theta_v + Math.toRadians(-120))),
            new Complex(r_v * Math.cos(theta_v + Math.toRadians( 120)), r_v * Math.sin(theta_v + Math.toRadians( 120)))
        };

        // 解
        Complex[] x = {
            new Complex(u[0].real + v[0].real - b/3, u[0].imag + v[0].imag),
            new Complex(u[1].real + v[1].real - b/3, u[1].imag + v[1].imag),
            new Complex(u[2].real + v[2].real - b/3, u[2].imag + v[2].imag),
        };

        // 解を表示
        for(Complex cox: x) System.out.println(cox);
        
    }
}

class Complex {
    /** 実数 */
    final public double real;
    /** 嘘数 */
    final public double imag;

    /** コンストラクタ */
    Complex(double r, double i) {this.real = r; this.imag = i;}
    
    @Override public String toString() {
        // 少数第4位まで表示
        return String.format("%.4f %c %.4f i", real, (imag > 0) ? '+' : '-', Math.abs(imag));
    }
}
