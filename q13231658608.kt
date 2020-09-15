
class MainActivity : AppCompatActivity() {
    /**
     * この画面で表示する日付
     * 次の日、前の日ボタンが押されたときは、Intentデータに従い、アプリ起動時はシステムから取得する
     */
    private val mToDay: LocalDate by lazy { LocalDate.parse(intent?.getStringExtra("ToDay") ?: LocalDate.now().toString()) }

    /** 日付とメモ内容の紐づけ */
    private val mMemoList = mapOf(
        LocalDate.of(2020,9,14) to listOf("牛乳 100円", "水 50円"), // 2020/09/14 のリスト
        LocalDate.of(2020,9,15) to listOf("牛乳 100円", "水 60円"), // 2020/09/15 のリスト
        LocalDate.of(2020,9,16) to listOf("牛乳 100円", "水 70円"), // 2020/09/16 のリスト
        LocalDate.of(2020,9,17) to listOf("牛乳 100円", "水 80円"), // 2020/09/17 のリスト
        LocalDate.of(2020,9,18) to listOf("牛乳 100円", "水 90円")  // 2020/09/18 のリスト
    )

    /**
     * Activity起動時の処理
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 日付を表示する
        to_day.text = mToDay.toString()
        // メモリストを表示する
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mMemoList[mToDay] ?: listOf("データがないよ"))
    }

    /**
     * 次の日、前の日のボタンを押したときの動作
     * @param View 押されたボタン
     */
    fun onClickButton(view: View) {
        // ページ送りが必要？らいしいので、自身のActivityを再表示させる
        val intent = Intent(applicationContext, MainActivity::class.java)
        when (view.id ) {
            // 次の日ボタン押下時は、今の日付を一日増やしたデータを渡す
            R.id.button1 -> intent.putExtra("ToDay", mToDay.plusDays(1).toString())
            // 前の日ボタン押下時は、今の日付を一日減らしたデータを渡す
            R.id.button2 -> intent.putExtra("ToDay", mToDay.minusDays(1).toString())
        }

        // 画面遷移実行＆自分を終了
        startActivity(intent)
        finish()
    }
}
