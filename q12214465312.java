// 【check1】java.util.Randomクラスを使用可能なように設定する。
import java.util.Random;

class RandomNumber {
    // 【check2】乱数の最大値を格納する変数randMaxを持つ。初期値は2に設定する。クラス外からアクセスできない。
    private int randMax = 2;
    
    // 【check3】クラス外からアクセス可能なコンストラクタを一つ持つ。
    // このコンストラクタは、整数型の引数maxを一つ持ち、
    public RandomNumber(int max){
        // インスタンス生成時にmaxの値が3以上のとき、maxの値をrandMaxに代入する。
        if (max >= 3) randMax = max;
        else if (max < 3);// 3未満のときは何も行わない
    }

    // 【check4】実行の都度乱数を返却するメソッドgetNum()を持つ
    // 返却される整数は1からrandMaxまでの大きさのランダムな整数とする。
    public int getNum() {
        // 乱数の生成はRandomクラスのインスタンスrを生成し、
        // そのメソッドnextDouble()の返却する0.0以上1.0未満を使って行う。
        Random r = new Random(); // ★乱数ジェネレータは毎回インスタンスを生成するものではない。メンバ変数にすべき。仕様がおかしい
        
        // ◇ nextDouble()を使って0.0以上1.0未満の乱数を発生させる。
        double d = r.nextDouble();
        
        // ◇ 乱数にrandMaxを乗算して、0.0以上randMax未満の乱数にする
        d = randMax * d;
        
        // ◇ int型にキャストを行って0以上randMax未満の整数(0からrandMax-1の整数)にする。
        int num  = (int) d;
        
        // ◇ 整数に + 1をして1からrandMaxの整数にする
        num += 1;
        
        return num;
    }
}

class ConfirmingRandom {
    public static void main(String[] args) {
        // 【check1】minメソッド内でRandomNumberクラスのインスタンスrandを、コンストラクタの引数を10として生成する。
        RandomNumber rnd = new RandomNumber(10);

        // 【check2】整数型の配列変数countを要素数10として生成する
        int[] count = new int[10];
        // 【check3】続いて、繰り返し文を用いてrandのgetNum()を10000回実行し、
        for (int i = 0; i <10000; i++) {
            int num = rnd.getNum();
            // 発生した乱数の値を元に配列変数countを用いて1から10の出現回数を以下のようにカウントする。
            count[num - 1]++;
        }
        
        // 【check4】[出現回数]と表示した後、
        System.out.println("[出現回数]");
        // 繰り返し文を用いて乱数生成時の1から10の出現回数を表示する
        for (int i =0; i <10; i++) {
            System.out.println((i + 1) + ":"+ count[i]);
        }
    }
}
