import javax.swing.JFrame;
import javax.swing.JButton;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class Main {
    public static void main(String[] args) {
        // Latexで文字生成
        String latex = "x = \\frac{a}{b}";
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
            .setSize(20)
            .setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_CENTER)
            .setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f)
            .build();

        // JFrameの生成
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.getContentPane().add(new JButton(icon));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
