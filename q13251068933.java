public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /* LitViewで表示する基データ　*/
    private static class CheckData {
        String text; //チェックボックスのメッセージ
        boolean check; // チェック状態
        CheckData(String s, boolean b) {text = s; check = b; }
    }

    // ListViewで表示するListを生成
    private final List<CheckData> mList = IntStream.range(0, 1000)
            .mapToObj(n -> new CheckData(n + "番目", false)).collect(Collectors.toList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv = findViewById(R.id.listView);
        lv.setDivider(null); // ListViewの境界線を消す
        lv.setAdapter(new ArrayAdapter<CheckData>(this, 0, mList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CheckBox cb = (convertView instanceof CheckBox)
                        ? (CheckBox)convertView : new CheckBox(getApplicationContext());

                CheckData data = getItem(position);
                cb.setText(data.text);
                cb.setChecked(data.check);
                cb.setTag(position); // ViewにIndexを紐づけておく
                cb.setOnClickListener(MainActivity.this);
                return cb;
            }
        });
    }
    /** チェックが押されたら、Listのデータを更新 */
    @Override public void onClick(View v) {
        int n = (Integer)v.getTag();
        mList.get(n).check = ((CheckBox)v).isChecked();
    }
}
