import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
 
class Sample {
  public static void main(String args[]) {
    try {
      File f = new File("sample.csv");
      InputStreamReader osr  = new InputStreamReader(new FileInputStream(f), "SJIS");
      BufferedReader br = new BufferedReader(osr);
 
      String line;
      // 1行ずつCSVファイルを読み込む
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換

        // Beanのインスタンス生成
        Bean bean = new Bean(data[0], data[1]);
        // beanを表示する
        System.out.println(bean);
      }
      br.close();
 
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

/**
 * カラムが２つ(両方String型)のBeanクラスを定義
 */
class Bean {
    /** カラム情報 */
    final String str1, str2;

    /**
     * コンストラクタでカラムを代入する
     * @param str1 カラム１
     * @param str2 カラム２
     */
    Bean(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    /**
     * System.out.println()で出力する文字列
     */
    @Override
    public String toString() {return String.format("[Bean]str1 = %s, str2 = %s", str1, str2);}
}
