import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
  
public class Main {

    final static String INPUT_IMAGE = "image.jpg";// 読み込み画像（このjavaファイルと同じフォルダに入れとく）
    final static String OUTPUT_IMAGE = "reslt.jpg";// 出力する画像（このjavaファイルと同じフォルダに出力される）
      
    public static void main(String[] args) throws IOException {
          
        // 画像読み込み
        File in_file = new File(INPUT_IMAGE);
        BufferedImage read = ImageIO.read(in_file);
          
        // 情報取得 w, hは縦、横のピクセル数。writeは画像の1ピクセルごとにアクセスできるようにしてる
        int w = read.getWidth(), h = read.getHeight();
        BufferedImage write = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        // 格ピクセルに処理していく
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                // 色抽出
                int color = read.getRGB(x, y); // 座標の色を取得
                int red   = (color & 0xff0000) >> 16; // 赤抽出
                int green = (color & 0x00ff00) >> 8;  // 緑抽出
                int blue  = (color & 0x0000ff) >> 0;  // 青抽出

                // 高さ半分より下はグレースケール変換
                if (h / 2 < y) {
                    int g = (int)(0.2126 * red + 0.7152 * green + 0.0722 * blue);
                    red   = g;
                    green = g;
                    blue  = g;
                }

                // 出力用にフォーマット
                red   = (red << 16)  & 0xff0000;
                green = (green << 8) & 0x00ff00;
                blue  = (blue << 0)  & 0x0000ff;
                color = 0xff000000 | red | green | blue;
                write.setRGB(x, y, color); // 情報変換した色をもとの座標に戻す
            }
        }
          
        // 画像の出力
        File out_file = new File(OUTPUT_IMAGE);
        ImageIO.write(write, "jpg", out_file);
    }
}
