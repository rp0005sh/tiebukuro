public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageViewにボタンのClick処理設定
        findViewById(R.id.image_button).setOnClickListener(onClickSetImage);
    }

    /** クリックリスナー */
    View.OnClickListener onClickSetImage = new View.OnClickListener() {
        // リスナーのメンバ変数で画像情報を覚えておく
        int res_id = R.drawable.XXX;

        @Override
        public void onClick(View v) {
            // 画像情報更新
            switch(res_id) {
                case R.drawable.XXX: res_id = R.drawable.YYY; break; // XXXなら、YYYへ
                case R.drawable.YYY: res_id = R.drawable.XXX; break; // YYYなら、XXXへ
            }

            // 画像切り替え
            ((ImageView)v).setImageResource(res_id);
        }
    };
}
