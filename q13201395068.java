import javax.swing.JFrame;
import javax.swing.JButton;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ボタンの設定
        JButton button = new JButton("こんにちは");
        frame.getContentPane().add(button);
        // ボタン押したときの動作を設定する
        button.addActionListener(e -> {
            // ボタンのオブジェクトを取得
            JButton btn = (JButton)e.getSource();
            // ボタンの文字が「こんにちは」か判定
            if (btn.getText().toString().equals("こんにちは")) {
                // ボタンの文字を「さようなら」に変更
                btn.setText("さようなら");
            } else {
                // ボタンの文字を「こんにちは」に変更
                btn.setText("こんにちは");
            }
        });
        frame.setVisible(true);
    }
}
