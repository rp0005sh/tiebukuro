public class A4Graph {
    public static void main(String args[]) {
        List<Integer> path = new ArrayList<>();
        int num = getPath(1, 5, path);
        String result;
        if (num == -1) result = "no path";
        else result = "最小コスト = " + num + ", パス = " + path.toString();
        System.out.println(result);
    }

    // 質問者さん側で実装済みの為省略
    public static int[][]getMatrix(String filename) {/** 省略 */}

    /** コストtable */
    final static int[][] sAdjacencyMatrix = getMatrix("graph1.txt");

    /** 移動可能route */
    final static int[][] route = {
        {6},       // Node[0]から移動できるNode番号
        {2, 3},    // Node[1]から移動できるNode番号
        {0, 3},    // Node[2]から移動できるNode番号
        {1, 5, 6}, // Node[3]から移動できるNode番号
        {0, 2, 6}, // Node[4]から移動できるNode番号
        {1},       // Node[5]から移動できるNode番号
        {},        // Node[6]から移動できるNode番号
    };

    /**
     * 最小コストで移動するルートを探す
     * @param startNode 現在地
     * @param endNode 目的地
     * @param history 移動履歴
     * @return 現在地から目的地までにかかる最小コスト
     *         移動ルートがない場合は-1を返す
     *         移動ルートがループする場合は-1を返す
     */
    public static int getPath(int startNode, int endNode, List<Integer> history) {
        // 現在地が移動履歴にあるなら、ループしている事になるので-1で抜ける
        if(history.contains(startNode)) return -1;

        // 移動履歴に現在地を追加
        history.add(startNode);

        // 現在地が目的地と同じなら探索終了.この動作に移動コストはないので「0」を返す
        if(startNode == endNode) return 0;

        // 最小コストでの移動を探す
        int min = Integer.MAX_VALUE; // とりあえず、最小値の初期値はint型の最大値にしておく
        List<Integer> path = null;   // 最小コストのNodeを通るときのパス
        // 現在地から移動可能なNodeを全て探査
        for (int next : route[startNode]) {
            // 「次のNode」から「目的地」を再帰的に探す
            List<Integer> tmp = new ArrayList<>(history);
            int value = getPath(next, endNode, tmp);
            // -1は移動不可か、移動がループしてるので次のNodeへ
            if(value == -1) continue;

            // コスト計算([現在地⇒次のNode] + [次のNode⇒目的地])
            int cost = sAdjacencyMatrix[startNode][next] + value;
            // コストが現在の最小値より低ければ最小値を更新
            if(min > cost) {
                min = cost;
                path = tmp;
            }
        }

        // 最小コストのルートが見つからなければ-1
        if(path == null) return -1;

        // 見つかれば、移動履歴を更新し、最小コスト値を戻す
        history.clear();
        history.addAll(path);
        return min;
    }
}
