public class Main {
    public static void main(String[] args) throws java.io.IOException {
    	// ファイルの中身を全部Listで読み込む
    	java.util.List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get("data.csv"));

    	// booleanの二次元配列に置き換えていく
    	boolean[][] result = new boolean[lines.size()][];
    	for(int i = 0; i < result.length; i++) {
    		// Listから一行分取り出して、「,」で区切った配列を取得
    		String[] column = lines.get(i).split(",");

    		// String配列をboolean配列に変換していく
    		boolean[] tmp = new boolean[column.length];
    		for (int j = 0; j < tmp.length; j++) {
    			tmp[j] = Boolean.valueOf(column[j]);
    		}

    		// 二次元配列に追加
    		result[i] = tmp;
        }

    	// 得られたboolean二次元配列の中身をコンソールに出力
        for(boolean[] array : result) {
            System.out.println(java.util.Arrays.toString(array));
        }
    }
}
