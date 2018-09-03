public class Main {
    public static void main(String[] args) throws java.io.IOException {
        boolean[][] ret = java.nio.file.Files
        // 読み込むCSVファイルを設定
        .lines(java.nio.file.Paths.get("data.csv"))
        // ファイルから一行ずつ読み込んで、「,」で区切った文字列配列へ変換
        .map(line -> line.split(","))
        // 文字列配列をboolean配列に変換
        .map(array -> {
            boolean[] b = new boolean[array.length];
            for (int i = 0; i < b.length; i++) b[i] = Boolean.valueOf(array[i]);
            return b;})
        // 二次元配列で出力
        .toArray(boolean[][]::new);

        // 得られたboolean二次元配列の中身をコンソールに出力
        for(boolean[] array : ret) {
            System.out.println(java.util.Arrays.toString(array));
        }
    }
}
