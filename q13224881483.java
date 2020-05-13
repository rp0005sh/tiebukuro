import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        // 0 ≦ x < 10, 0 ≦ y < 10 の空間を作り、「.」で埋める
        String[][] map = new String[10][10];
        for (String[] col : map) Arrays.fill(row, "."); 

      /* +----------------------------------------------------------+
         | 二次元配列で空間を作る際は 配列[y座標][x座標]となります。| 
         +----------------------------------------------------------+*/
        // f(x) = x に該当する部分を"X"に塗り替える
        for (int x = 0; x < 10; x++) map[x][x] = "X";
        // f(x) = -x + 10 に該当する部分を"X"に塗り替える
        for (int x = 0; x < 10; x++) map[-x + 10-1][x] = "X";

        // 全体を表示する
        for (String[] col : map) System.out.println(String.join("", row));
    }
}
