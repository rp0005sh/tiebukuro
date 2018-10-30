import java.io.*;
import java.util.*;

class A4Graph {
    public static void main(String args[]) {
        String path = getPath(getMatrix("graph1.txt"), 1, 5);
        System.out.println(path);
    }

    // 質問者さん側で実装済みの為省略
    public static int[][]getMatrix(String filename) {/** 省略 */}

    /**
     * 最短の移動ルートを探す
     * @param adjacencyMatrix 隣接ノード表
     * @param startNode 現在地
     * @param endNode 目的地
     * @return 現在地から目的地までにかかる最短パス
     *         移動ルートがない場合はno pathを返す
     */
    public static String getPath(int[][] adjacencyMatrix, int startNode, int endNode) {

        // 現在地が目的地と同じなら探索終了.
        if(startNode == endNode) return String.valueOf(endNode);

        // 現在地から移動可能なNodeを全て探査
        List<String> pathList = new ArrayList<String>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            // 次のノード先を決定
            if(adjacencyMatrix[startNode][i] == 0) continue;
            int nextNode = i;

            // 隣接ノード表をコピーして、現在地を0にする。これにより、次の遷移先から再び現在地に戻ることを抑止
            int[][] nextMatrix = Arrays.stream(adjacencyMatrix).map(row -> row.clone()).toArray(int[][]::new);
            nextMatrix[startNode][nextNode] = 0;

            // 「次のノード⇒ 目的地」でパスを探す(再帰処理)
            String path = getPath(nextMatrix, nextNode, endNode);
            // パスがない場合は、次のノードへ
            if(path.equals("no path")) continue;
            // パスがあれば、パスリストに保存
            pathList.add(startNode + "->" + path);
        }

        // パスリストを文字数少ない順に並び替えて、最短ルートを探す。ない場合は"no path"
        String path = pathList.stream().sorted((p1, p2) -> p1.length() - p2.length()).findFirst().orElse("no path");
        return path;
    }
}
