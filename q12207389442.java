import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

class Main {

    public static void main(String[] args) {
        // frameの設定
        JFrame frame = new JFrame("AbsoluteLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(302, 127);
        frame.setLayout(null);

        // ボタン生成とframeに突っ込む
        JButton b1 = new JButton("one"), b2 = new JButton("two"), b3 = new JButton("three");
        frame.add(b1);frame.add(b2);frame.add(b3);

        // ボタンの位置設定
        b1.setBounds(25, 6, 54, 24);
        b2.setBounds(55, 40, 52, 25);
        b3.setBounds(150, 15, 111, 45);

        // 文字の太さ・大きさ・フォルトの設定
        Font font = new Font("Dialog", Font.ROMAN_BASELINE, 10);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);

        // frameを表示する
        frame.setVisible(true);
    }
}
