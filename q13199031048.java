import java.awt.geom.Point2D;
import java.util.Arrays;
import javax.swing.JFrame;

class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(MyJPanel.WINDOW_WIDTH, MyJPanel.WINDOW_HEIGHT);
        frame.getContentPane().add(new MyJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MyJPanel extends javax.swing.JPanel {
    /** 画面の大きさ 幅と高さ */
    static final int WINDOW_WIDTH  = 500;
    static final int WINDOW_HEIGHT = 500;

    /** 粒子の座標 */
    final private Point2D.Double[] m;
    /** 重心の座標 */
    final private Point2D.Double g;
    /** 角速度 */
    final double omega;
    /** 並進速度 */
    double v;


    /**
     * コンストラクタ
     * <p>各粒子位置、重心、速度の初期化。および座標更新タイマの設定</p>
     */
    public MyJPanel() {
        // 粒子の座標を決める
        m = new Point2D.Double[] {
                new Point2D.Double(50, 50), // m1
                new Point2D.Double(50, 70), // m2
                new Point2D.Double(50, 90), // m3
                new Point2D.Double(70, 90), // m4
        };

        // 重心を計算(粒子の重さが全て等しい場合、座標平均が重心となる)
        g = new Point2D.Double(
            Arrays.stream(m).mapToDouble(p -> p.x).average().getAsDouble(),
            Arrays.stream(m).mapToDouble(p -> p.y).average().getAsDouble());
        
        // 角速度(100回描画で1回転)
        omega = 2 * Math.PI / 100;
        
        // 並進速度
        v = 3d;
        
        // 30ミリ秒おきに位置座標を更新して、描画更新要求
        new javax.swing.Timer(30, e -> {

            // 重心が画面の端に来たらとりあえず折り返す
            if(g.x < 0 || WINDOW_WIDTH < g.x)v *= -1;

            // 並進運動による位置更新
            g.x += v;
            // 各粒子の位置更新
            for (Point2D.Double p : m) {
                double x = p.x + v, y = p.y;
                p.x = (x - g.x) * Math.cos(omega) - (y - g.y) * Math.sin(omega) + g.x;
                p.y = (x - g.x) * Math.sin(omega) + (y - g.y) * Math.cos(omega) + g.y;
            }

            // 描画更新要求
            repaint();
        }).start();
    }

    /**
     * 描画処理
     * <p>各粒子の描画。重心を赤で描画</p>
     * @param g グラフィックス
     */
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // 粒子の描画
        for(Point2D.Double p : m) {
            // とりえあえず、半径を20にしてる
            g.drawOval((int)p.x, (int)p.y, 20, 20);
        }

        // 重心は赤で描画(重心描画不要なら、以下二行を削除)
        g.setColor(java.awt.Color.red);
        g.drawOval((int)this.g.x, (int)this.g.y, 5, 5);
    }
}
