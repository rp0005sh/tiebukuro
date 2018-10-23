public class Main {

    public static void main(String[] args) {
        // チェックしたい対象の文字列配列
        String[] terget = {"101", "-1", "255", "aaa", "あか"};

        // isByte()でフィルタリングして、対象の文字のみ拾う
        String[] result = java.util.Arrays.stream(terget)
            .filter(Main::isByte).toArray(String[]::new);

        // 最終結果を出力してみる
        System.out.println(java.util.Arrays.toString(result));
    }

    /** Byteに変換できるかチェックする
     * @param str チェックする文字列
     * @return true:Byte変換可能、false:Byte変換不可
     */
    public static boolean isByte(String str) {
        boolean b = true;
        try {Byte.parseByte(str);}
        catch (NumberFormatException e){b = false;}
        return b;
    }
}
