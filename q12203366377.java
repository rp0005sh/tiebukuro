import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
  
public class Main {
    /** 読み込み画像(上)ファイル名 */
    final static String INPUT_IMAGE1 = "image1.jpg";
    /** 読み込み画像(下)ファイル名 */
    final static String INPUT_IMAGE2 = "image2.jpg";
    /** 出力画像ファイル名 */
    final static String OUTPUT_IMAGE = "reslt.jpg";

    public static void main(String[] args) throws IOException {

        // 画像読み込み
        BufferedImage read1 = ImageIO.read(new File(INPUT_IMAGE1));
        BufferedImage read2 = ImageIO.read(new File(INPUT_IMAGE2));

        // 読み込み画像の縦、横大きさ取得
        int w1 = read1.getWidth(), h1 = read1.getHeight();
        int w2 = read2.getWidth(), h2 = read2.getHeight();

        // 出力画像の大きさを計算
        int w = Math.max(w1, w2), h = h1 + h2;
        BufferedImage write = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        // 一枚目の画像の書き込み
        for(int y = 0; y < h1; y++) {
            for(int x = 0; x < w1; x++) {
                write.setRGB(x, y, read1.getRGB(x, y));
            }
        }

        // 二枚目の画像の書き込み
        for(int y = 0; y < h2; y++) {
            for(int x = 0; x < w2; x++) {
                write.setRGB(x, y + h1, read2.getRGB(x, y));
            }
        }

        // 結合した画像の出力
        ImageIO.write(write, "jpg", new File(OUTPUT_IMAGE));
    }
}
