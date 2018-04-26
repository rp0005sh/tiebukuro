import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	/** テスト件数 */
	final static int TEST = 20000;
	/** 円の中に入る点の数 */
	int count = 0;
	/** ループ回数 */
	int loop = 1;
	/** 乱数ジェネレータ */
	final Random r = new Random();

	public static void main(String[] args) {
		new Main();
	}

	Main() {
		setBounds(100, 100, 370, 370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				// 円と四角を描画
				g.setColor(Color.black);
				g.drawRect(20, 20, 240, 240);
				g.drawOval(20, 20, 240, 240);

				// ランダムに赤点を打つ
				g.setColor(Color.red);
				int x = r.nextInt(240) + 20, y = r.nextInt(240) + 20;
				g.drawRect(x, y, 1, 1);
				
				// 円の中に赤点が入っているかチェック
				if ((x - 140) * (x - 140) + (y - 140) * (y - 140) < 120 * 120)count++;
				
				// 計算過程を表示
				g.setColor(Color.white);
				g.fillRect(270, 30,100,20);
				g.setColor(Color.blue);
				g.drawString("円周率:" + (4.0 * count / loop), 270, 45);
				if (TEST > loop++) repaint();
			}
		});
		setVisible(true);
	}
}
