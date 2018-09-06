public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageViewにボタンのClick処理設定
        findViewById(R.id.image_button).setOnClickListener(onClickSetImage);
    }

    /** クリック処理 */
    View.OnClickListener onClickSetImage = v -> {
        // Viewのタグから画像情報を取得
        int res_id = v.getTag() != null ? v.getTag() : R.drawable.XXX;

        // 切り替え画像決定
        switch(res_id) {
            case R.drawable.XXX: res_id = R.drawable.YYY; break; // XXXなら、YYYへ
            case R.drawable.YYY: res_id = R.drawable.XXX; break; // YYYなら、XXXへ
        }

        // 画像切り替え
        ((ImageView)v).setImageResource(res_id);

        // タグも書き換え
        v.setTag(res_id);
    };
}
