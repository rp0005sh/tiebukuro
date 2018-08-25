public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ボタンにリスナーを設定
       findViewById(R.id.button).setOnClickListener(new CountClickListener(3));
    }
}

/**
 * 押下回数をカウントして、規定回数に達したら押せなくするリスナークラス
 */
class CountClickListener implements View.OnClickListener {
    /** ボタン押下された回数 */
    int count = 0;
    final int max;

    /**
     * コンストラクタでカウントの規定値を決める
     * @param n カウント数
     */
    public CountClickListener(int n) {
        this.max = n;
    }

    @Override public void onClick(View v) {
        // ボタンの押下をカウントを増やす
        count++;

        // 3回以上押されたときの処理
        if (max <= count) {
            v.setEnabled(false);                // グレーアウト(押せない状態)する
            // v.setClickable(false);           // ボタンを押せない状態にする
            // v.setVisibility(View.INVISIBLE); // ボタンを非表示(見えなくする)にする
            // v.setVisibility(View.GONE);      // ボタンを非表示(ボタン自体をなかったことにしてレイアウトを再構成)にする
            // v.setOnClickListener(null);      // ボタンは押せるが、イベントを発生させない
        }
    }
}
