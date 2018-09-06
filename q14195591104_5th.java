public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    	// ImageViewにボタンのClick処理設定
        findViewById(R.id.image_button).setOnClickListener(onClickSetImage1);
    }

	/** Viewの画像をXXXへ変更 */
    View.OnClickListener onClickSetImage1 = new View.OnClickListener() {
        public void onClick(View v) {
            // 画像切り替え
            ImageView iv = (ImageView) v;
            iv.setImageResource(R.drawable.XXX);

            // リスナーを切り替えて、次のClickは別のClickイベントを実行させる
            iv.setOnClickListener(onClickSetImage2);
        }
    };

    /** Viewの画像をYYYへ変更 */
    View.OnClickListener onClickSetImage2 = new View.OnClickListener() {
        public void onClick(View v) {
            // 画像切り替え
            ImageView iv = (ImageView) v;
            iv.setImageResource(R.drawable.YYY);

            // リスナーを切り替えて、次のClickは別のClickイベントを実行させる
            iv.setOnClickListener(onClickSetImage1);
        }
    };
}
