手順１．表示する画像のリストを作る
　　「res/drawable」に適当にXMLファイルを作る
　　※仮に「list_image.xml」とする。ファイルの中の記述は以下
<?xml version="1.0" encoding="utf-8"?>
<level-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:maxLevel="0" android:drawable="@drawable/WWWWWW" /> ⇒ Drawableのレベル「0」のときは画像「WWWWW.jpg」の画像
    <item android:maxLevel="1" android:drawable="@drawable/XXXXXX" /> ⇒ Drawableのレベル「1」のときは画像「XXXXX.jpg」の画像
    <item android:maxLevel="2" android:drawable="@drawable/YYYYYY" /> ⇒ Drawableのレベル「2」のときは画像「YYYYY.jpg」の画像
    <item android:maxLevel="3" android:drawable="@drawable/ZZZZZZ" /> ⇒ Drawableのレベル「3」のときは画像「ZZZZZ.jpg」の画像
</level-list>


手順２．ImageButtonのレイアウト定義
レイアウトを決めるとき、ImageButtonの「android:src」を上記で定義したXMLファイルを指定
   ：
    <ImageButton
        android:id="@+id/image_button"
        android:src="@drawable/list_image" ★ここ
        android:text="hello_world"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
   ：


手順３．実装
クリックリスナーでDrawableのレベルを変更することで、画像を差し替えを実現させる
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageViewにボタンのClick処理実装
        findViewById(R.id.image_button).setOnClickListener(onClickSetImage);
    }

    /** クリックリスナー */
    View.OnClickListener onClickSetImage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // ViewからDrawableを取得
            Drawable drawable = ((ImageView) v).getDrawable();

            // 現在設定しているレベルから次に表示する画像に差し替え
            switch (drawable.getLevel()) {
                case 0: drawable.setLevel(1); break;
                case 1: drawable.setLevel(0); break;
            }
        }
    };
}
