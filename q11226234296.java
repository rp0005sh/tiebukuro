public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // GridViewを生成
        GridLayout layout = new GridLayout(this);
        layout.setColumnCount(9); // 縦幅を9マス用意
        layout.setRowCount(9);    // 横幅を9マス用意

        // ループで数値を詰めていく
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 配置するグリッドViewの位置指定[横：i][縦：j]
                GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(i), GridLayout.spec(j));
                param.width = param.height = 100;

                // 配置する文字を定義
                TextView tv = new TextView(this);
                tv.setText(String.format("%4d", (i+1) * (j+1)));

                // グリッドレイアウトに追加していく
                layout.addView(tv, param);
            }
        }
        
        // 画面にグリッドレイアウトを配置
        setContentView(layout);
    }
}
