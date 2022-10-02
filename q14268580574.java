import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.IntStream;

class Kaijo {
    public static void main(String args[]) {
        try(BufferedReader d = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                // 入力処理
                System.out.print("1以上の整数を入力してください:");
                String str = d.readLine(), result;

                // 処理の分岐
                if ("exit".equals(str)) break;
                try {
                    int num = Integer.parseInt(str);
                    if (1 <= num) result = num + "の階乗は" + kaijo(num);
                    else result = "エラー 入力された値は1以上ではありません。";
                } catch (NumberFormatException e) {
                    result = "エラー 入力された値は整数ではありません";
                }

                // 結果を表示する
                System.out.printf("%s%n%n", result);
            }
        } catch(IOException e) {
            System.out.println("IQエラー");
        }
    }
    
    // 階乗の計算
    private static BigInteger kaijo(int n) {
        return IntStream.range(1,n + 1).mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
