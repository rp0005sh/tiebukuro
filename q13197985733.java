public class Main {

    public static void main(String[] args) {
        // チェックしたい対象の文字列配列
        String[] terget = {"101", "aaa", "あか"};

        // チェックリスト作成
        String[] check = new String[0xFF + 1];
        for (int i = 0x00; i <= 0xFF; i++) {
            check[i] = String.valueOf(i);
        }
        // バイナリ―サーチを使うので、昇順ソートしておく
        java.util.Arrays.sort(check);

        // 対象の文字列リストを一軒ずつ確認、該当者をlistへ格納
        java.util.List<String> list = new java.util.ArrayList<>();
        for (String str : terget) {
            if (java.util.Arrays.binarySearch(check, str) > -1) {
                list.add(str);
            }
        }
        // Listから、配列へ変換
        String[] result = list.stream().toArray(String[]::new);
        
        // 最終結果を出力してみる
        System.out.println(java.util.Arrays.toString(result));
    }
}
