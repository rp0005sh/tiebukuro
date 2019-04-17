public class Main {
    public static void main(String[] args) {
        // アルファベットの配列をスペースで初期化
        char[] alphabet = new char[26];
        java.util.Arrays.fill(alphabet, ' ');

        // 繰り返し文でa～zまで回す
        for (char c = 'a'; c <= 'z'; c++) {
            // 配列の先頭からアルファベットを代入していく
            alphabet[c - 'a'] = c;

            // 現在の配列を出力していく
            System.out.println(alphabet);
        }
    }
}
