public class Main {
    public static void main(String[] args) {
        // アルファベット配列を生成
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // 26回(zまで)繰り返す
        for (int i = 0; i < 26; i++) {
        	// 表示する
            System.out.println(java.util.Arrays.copyOfRange(alphabet, 0, i + 1));
        }
    }
}
