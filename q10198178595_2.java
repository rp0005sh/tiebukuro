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
        java.util.Comparator<String> sort2 = (p1, p2) -> {
            int sum1 = 0, sum2 = 0, arr[];
            // p1のコスト計算
            arr = Arrays.stream(p1.split("->")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < arr.length - 1; i++)  sum1 += adjacencyMatrix[arr[i]][arr[i+1]];
            // p2のコスト計算
            arr = Arrays.stream(p2.split("->")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < arr.length - 1; i++) sum2 += adjacencyMatrix[arr[i]][arr[i+1]];
            // 評価
            return sum1 - sum2;
        };

        // パスリストを並び替えて、ルートを探す
        return pathList.stream()
                .sorted(sort1) // 最短ノードでソート
              //.sorted(sort2) // 最小コストでソート（こっちでソートする際は先頭のコメントを外す)
                .findFirst().orElse("no path"); // ルートがない場合は"no path"
    }
}
