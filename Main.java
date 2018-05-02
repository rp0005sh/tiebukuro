import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        // 円周上の2点の位置を乱数で定義
        double r = 2.0; // 円の半径
        double theta1 = 2 * PI * random(); // 点1
        double theta2 = 2 * PI * random(); // 点2

        // 計算
        double ret = r * sqrt(
                (cos(theta2) - cos(theta1)) * (cos(theta2) - cos(theta1))
              + (sin(theta2) - sin(theta1)) * (sin(theta2) - sin(theta1)));

        // 出力
        System.out.println(ret);
    }
}
