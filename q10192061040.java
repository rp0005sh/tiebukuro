import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[8][8];

        // 全マス目にアクセスして、描画を行う
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                drawBoard(new Point(j, i), board);
            }
        }

        // 結果のボードを表示させる
        for (int[] tmp : board) {
            System.out.println(java.util.Arrays.toString(tmp));
        }
    }

    /**
     * 八方位のベクトル
     */
    static final Point[] AZIMUTH_VECTOR = {
        new Point(-1, -1),// 左上
        new Point(-1,  0),// 左
        new Point(-1,  1),// 左下
        new Point( 0,  1),// 下
        new Point( 1,  1),// 右下
        new Point( 1,  0),// 右
        new Point( 1, -1),// 右上
        new Point( 0, -1),// 上
    };

    /**
     * 描画条件をチェックして、描画可能であれば1を描く
     * @param p 現在地(描画対象マス)
     * @param board ボード
     * @return true：描画成功, false：描画失敗
     */
    public static boolean drawBoard(Point p,int[][] board) {
        boolean flg = true;
        // 八方位を各方位ずつチェックしていく
        for(Point v : AZIMUTH_VECTOR) {
            flg &= check(p, v, board);
        }
        // 八方位すべてに「1」がいない場合は描画する
        if (flg) board[p.y][p.x] = 1;
        return flg;
    }

    /**
     * 現在位置から特定の方位に対して、マスの終端までに「1」があるかチェックする
     * @param p 現在位置
     * @param vec チェック方位
     * @param board ボード
     * @return true：「１」はなかった, false：「１」があった
     */
    private static boolean check(Point p, Point vec, int[][] board) {
        int len = board.length;
        boolean result = true;
        // 現在地から1マスずつチェックしていく
        for (int i = 1; i < len; i++) {
            // チェックするマスを取得
            int x = p.x + vec.x * i, y = p.y + vec.y * i;
            if (x < 0 || len <= x || y < 0 || len <= y) {
                // マスが終端まで来てたら終了
                break;
            } else if (board[y][x] == 1) {
                // マスの値が１だったら「結果NG」で終了
                result = false;
                break;
            }
        }
        return result;
    }
}
