import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 「quit」と入力されるまで，何回でも二次方程式を受け入れる
        while(true) {
            System.out.print("二次方程式のパラメータを入力してください > ");
            String line = sc.nextLine();

            if (line.equals("quit")) {break;} // 「quit」が入力されたら終了させる
            else { // そうじゃないとき
                try {
                    // 文字列から数値の配列へ変換し、二次方程式解法メソッド実行
                    double[] param = Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();
                    function(param[0], param[1], param[2]);
                } catch (RuntimeException e) {
                    // 数値に変換できなかったり、パラメータが不足してたらエラー
                    System.out.println("入力フォーマット不正。[実数,実数,実数]のようにカンマ区切りで数値を3つ入力してください");
                }
            }
        }
    }

    /** 二次方程式の解を表示する */
    static void function(double a, double b, double c) {
        //判別式
        double D = b * b - 4 * a * c;
        //a = 0の場合(一次方程式)
        if (a == 0) {
            double x = -c / b;
            System.out.println("x = " + x);
        }
        // 二次方程式の場合
        else {
            //解が２個あるパターン
            if (D > 0) {
                double x1 = (-b + Math.sqrt(D))/ (2 * a);
                double x2 = (-b - Math.sqrt(D))/ (2 * a);
                System.out.println("x = " + x1 + ", " + x2);
            }
            //重解のパターン
            else if (D == 0) {
                double x = (-b + Math.sqrt(D))/ (2 * a);
                System.out.println("重解 x = " + x);
            }
            //解なしパターン
            else if(D < 0) {
                System.out.println("解なし");
            }
        }
    }
}
