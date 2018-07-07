import java.awt.event.MouseEvent;
import javax.swing.JFrame;

class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.getContentPane().add(new MyJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * 円が、円状・直線・正弦波の軌跡を描いて移動するPanelクラス
 */
class MyJPanel extends javax.swing.JPanel {
    /** 円の座標、半径 */
    private int x, y, r;
    /** 軌跡インスタンス */
    private Trajectory trajectory; 

    public MyJPanel() {
        // 円情報の初期化
        x = 250; y = 250; r = 30;

        // 初期軌跡を直線に設定して、軌跡を初期化
        trajectory = line;
        trajectory.init();

        // パネルタッチ時に、軌跡の種類を変更し、軌跡の初期化を行う
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (trajectory == line)        {trajectory = circle;}
                else if (trajectory == circle) {trajectory = sin;}
                else if (trajectory == sin)    {trajectory = line;}
                trajectory.init();
            }
        });
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, r, r);
        update();
    }

    /**
     * 更新
     * <p>座標を更新して、再描画要求を行う</p>
     */
    public void update() {
        trajectory.update();
        try {Thread.sleep(10);}
        catch (InterruptedException e) {}
        repaint();
    }

    /** 軌跡インターフェース */
    interface Trajectory {
        /** 初期化 */
        void init();
        /** 位置情報更新 */
        void update();
    }

    /**
     * 直線軌跡インスタンス
     */
    Trajectory line = new Trajectory() {
        @Override public void init() {/* 初期化なし */}
        @Override public void update() {
            // 横方向に更新。横幅を超える場合0に戻る
            if(getWidth() < x++)x = 0;
        }
    };

    /**
     * 円軌跡インスタンス
     */
    Trajectory circle = new Trajectory() {
        /** 半径、角度 */
        float r, theta;
        @Override public void init() {
            // 画面の中心を基準に、現在座標を極座標化
            int w = x - getWidth() / 2;
            int h = y - getHeight() / 2;
            r = (float) Math.sqrt(w * w + h * h);
            theta = (float)Math.acos(w / r);
            if (h < 0) theta *= -1;
        }

        @Override public void update() {
            // 角度を1度上げ、極座標を直交座標に変換して更新
            theta += Math.toRadians(1);
            x = (int)(r * Math.cos(theta) + getWidth() / 2);
            y = (int)(r * Math.sin(theta) + getHeight() / 2);
        }
    };

    /**
     * 正弦波軌跡インスタンス
     */
    Trajectory sin = new Trajectory() {
        /** 振幅、周期,初期座標 */
        int a, t, x0, y0;
        @Override public void init() {
            a = 100;t = 100; // 振幅、周期
            x0 = x; y0 = y;  // 初期座標
        }

        @Override public void update() {
            // 左方向に進ませ、横幅を超えるなら0からやり直し
            x = x < getWidth() ? x + 1 : 0;
            y = (int) (a * Math.sin((x - x0) * 2 * Math.PI / t) + y0);
        }
    };
}
