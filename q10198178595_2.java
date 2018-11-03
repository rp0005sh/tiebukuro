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
        Set<String> pathList = new HashSet<String>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            // 次のノード先を決定
            if(adjacencyMatrix[startNode][i] == 0) continue;
            int nextNode = i;

            // 隣接ノード表をコピーして、「現在地⇒次のNode」を0にする。これにより、のちの遷移で同じルートに入るループを抑止
            int[][] nextMatrix = Arrays.stream(adjacencyMatrix).map(row -> row.clone()).toArray(int[][]::new);
            nextMatrix[startNode][nextNode] = 0;

            // 「次のノード⇒ 目的地」でパスを探す(再帰処理)
            String path = getPath(nextMatrix, nextNode, endNode);
            // パスがない場合は、次のノードへ
            if(path.equals("no path")) continue;
            // パスがあれば、パスリストに保存
            pathList.add(startNode + "->" + path);
        }

        /** 最短ノードでソート */
        java.util.Comparator<String> sort1  = (p1, p2) -> p1.split("->").length - p2.split("->").length;
        /** 最小コストでソート(エクストラ問題？で使用) */
        java.util.Comparator<String> sort2 = (p1, p2) -> getCost(adjacencyMatrix, p1) - getCost(adjacencyMatrix, p2);

        // パスリストを並び替えて、ルートを探す
        return pathList.stream()
                .sorted(sort1) // 最短ノードでソート
              //.sorted(sort2) // 最小コストでソート（こっちでソートする際は先頭のコメントを外す)
                .findFirst().orElse("no path"); // ルートがない場合は"no path"
    }

    /**
     * パスからコストを計算する関数
     * @param chart 使用する隣接ノードのコスト表
     * @param path コスト計算するパス
     * @return パスのコスト
     */
    static int getCost(int[][] chart, String path) {
        String[] format = path.replaceAll("(\\d)->","$1->$1,").split("->");
        return Arrays.stream(format).filter(str -> str.matches("\\d,\\d"))
                .map(str -> Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray())
                .reduce(0, (cal, arr) -> cal += chart[arr[0]][arr[1]], (sum, cal) -> sum += cal);
    }
}
