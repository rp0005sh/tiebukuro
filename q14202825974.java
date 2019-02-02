import javax.swing.*;
import java.net.*;

class Main {

    /** 表示する画像 */
    final static String url = "https://iwiz-chie.c.yimg.jp/im_sigg0sKr70YIqxDbdvmlv3vAbw---x320-y320-exp5m-n1/d/iwiz-chie/que-14202825974";

    public static void main(String[] args) throws MalformedURLException {
        JFrame f = new JFrame ();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        
        f.add(new JLabel(new ImageIcon(new URL(url))));
        f.setVisible(true);
    }
}
