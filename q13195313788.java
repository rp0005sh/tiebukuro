public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ボタンにClickリスナーを設定
       findViewById(R.id.button).setOnClickListener(listener);
    }

    /**
     * ボタンを押下するたびに色が変わるリスナー
     */
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView tv = (TextView) v;
            switch(tv.getTextColors().getDefaultColor()) {
                case Color.RED  : tv.setTextColor(Color.GREEN);  break; // 文字色が赤なら緑にする
                case Color.GREEN: tv.setTextColor(Color.YELLOW); break; // 文字色が緑なら黄にする
                default         : tv.setTextColor(Color.RED);    break; // その他は全て赤色にする
            }
        }
    };
}
