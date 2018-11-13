import java.util.Scanner;

public class watoseki {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("25以下の正の整数を入力してください：");
        byte n = stdIn.nextByte();

        // nが非正もしくは25より大きいのときの処理
        if (n <= 0 || 25 < n) {
            System.out.println("入力値が25以下の正の整数ではありません");
        } else {
            
            byte i                    = 1;                              // byte      型の変数i   を1で初期化
            int wa                    = 0;                              // int       型の変数wa  を0で初期化
            java.math.BigInteger seki = java.math.BigInteger.ONE;       // BigInteger型の変数sekiを1で初期化
            
            while ( i<=n ) {                                            // iがn以下の間ループ
                
                wa = wa + i;                                            // waにiを足した値をwaに代入
                seki = seki.multiply(java.math.BigInteger.valueOf(i));  // sekiにiを掛けた値をsekiに代入
                i++;                                                    // iを1増やす
            }
            System.out.println("1から" + n + "までの和は" + wa + "、積は" + seki + "です。");
        }
    }
}
