public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File f = new File("特定のパス"+"/pw.txt");
        // 「pw.txt」の存在チェック
        if (f.exists()) {
            // pw.txtがある場合
            // pw.txtを任意のディレクトリにコピー
            try (InputStream inStream = new BufferedInputStream(new FileInputStream(f));
                 OutputStream outStream = new BufferedOutputStream(new FileOutputStream("コピー先のパス"));) {
                byte[] buf = new byte[1024];
                int data;
                while ((data = inStream.read(buf)) != -1) {
                    outStream.write(buf, 0, data);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }

            // コピー完了。トースト表示
            Toast.makeText(getApplicationContext(),"コピー完了", Toast.LENGTH_LONG).show();
        } else {
            // pw.txtがない場合
            Toast.makeText(getApplicationContext(),"パスワードが未登録です", Toast.LENGTH_LONG).show();
        }

        // 標準ブラウザ起動
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com"));// 遷移先
        startActivity(i);

        // onCreateで自アプリを終了させることで、このアプリの表示物を見せなくする
        finish();
    }
}



アプリ起動アニメによる画面のチラつき抑止(透明Activityの表示法の一部抜粋)
「styles.xml」に以下の二行を追加
<item name="android:windowIsTranslucent">true</item>
<item name="android:windowTranslucentNavigation">true</item>
