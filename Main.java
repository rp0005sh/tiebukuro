import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 100);
        JCheckBox ckbox = new JCheckBox("チェックボックス");
        ckbox.addActionListener(listener); // クリックされたらリスナーを実行させる
        frame.getContentPane().add(ckbox);
        frame.setVisible(true);
    }

    /** チェックボックスのクリックリスナー */
    final static ActionListener listener = e -> {
        JCheckBox checkbox = (JCheckBox) e.getSource();

        if (!checkbox.isSelected()) {
            // クリックにより、チェックが外れる場合このルートを通る
            if (true/* 特定の条件 */) {
                // チェックをもう一度付ける
                checkbox.setSelected(true);
            }
        }
    };
}
