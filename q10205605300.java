public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // スピーナ１の文字配列からアダプター作る
        String[] obj = {"あ行","か行","さ行","た行","な行","は行","ま行","や行","ら行","わ行"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obj);

        // スピナー１の設定
        Spinner spinner = findViewById(R.id.sp1);
        spinner.setOnItemSelectedListener(listener);
        spinner.setAdapter(adapter);
    }


    /** スピナー１のアイテム選択時に、スピナー２のリストを設定するリスナー */
    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener(){
        // スピナー２に設定させたい配列達
        String[][] obj = {
            {"あ","い","う","え","お"}, // スピナー１で「あ行」選択時に表示
            {"か","き","く","け","こ"}, // スピナー１で「か行」選択時に表示
            {"さ","し","す","せ","そ"}, // スピナー１で「さ行」選択時に表示
            {"た","ち","つ","て","と"}, // スピナー１で「た行」選択時に表示
            {"な","に","ぬ","ね","の"}, // スピナー１で「な行」選択時に表示
            {"は","ひ","ふ","へ","ほ"}, // スピナー１で「は行」選択時に表示
            {"ま","み","む","め","も"}, // スピナー１で「ま行」選択時に表示
            {"や","ゆ","よ"},           // スピナー１で「や行」選択時に表示
            {"ら","り","る","れ","ろ"}, // スピナー１で「ら行」選択時に表示
            {"わ","を","ん"}            // スピナー１で「わ行」選択時に表示
        };

        /** アイテムを選択したときにCallされる */
        @Override 
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // スピナー２インスタンス取得
            Spinner sp = findViewById(R.id.sp2);

            // アダプター作って、スピナー２へ設定
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, obj[pos]);
            sp.setAdapter(adapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {/*今回は使用しない*/}
    };
}
