public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageViewにボタンのClick処理実装
        findViewById(R.id.image_button).setOnClickListener(new View.OnClickListener() {
            // リスナーのメンバ変数に変更する画像のDrawableを保持する
            final Drawable drawable1 = getDrawable(R.drawable.XXX);
            final Drawable drawable2 = getDrawable(R.drawable.YYY);

            @Override
            public void onClick(View v) {
                // 現在設定中のDrawableを取得
                ImageView iv = (ImageView)v;
                Drawable d = iv.getDrawable();

                // 画像の変更処理
                if     (d == drawable1) iv.setImageDrawable(drawable2);
                else if(d == drawable2) iv.setImageDrawable(drawable1);
                else  /*    その他   */ iv.setImageDrawable(drawable2);
            }
        });
    }
}
