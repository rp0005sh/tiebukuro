import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/**
 * 郵便番号から住所を調べるAPIのサンプルコード
 * <p>
 * http://zipcloud.ibsnet.co.jp/doc/api
 * 上記ホームページから「ベースとなるURL」を"XXXXXXXXXXXXX"の部分と差し替えると動く<br>
 * APIの利用には、上記URLより利用規約をしっかり読みましょう<br>
 * </p>
 */
public class Main  {
    public static void main(String[] args) throws IOException {
        
        // 郵便番号入力
        String zipcode = "783-0060";// 高知県南国市蛍が丘
        
        
        // URL作って接続
        String urlString = "XXXXXXXXXXXXX"+ "?zipcode=" + zipcode;
        java.net.URL url = new java.net.URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        

        // JSONデータの読み込み
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tmp;
        while ((tmp = in.readLine()) != null) {
            // 出力
            System.out.println(tmp);
        }

        // 終了処理
        in.close();
        con.disconnect();
    }
}
