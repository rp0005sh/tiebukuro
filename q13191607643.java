「MainActivity.java」ファイル

public class MainActivity extends AppCompatActivity {
    private DBAdapter dbAdapter;
    private MDaseAdapter myBaseAdapter;
    private List<MyListItem> items;
    private ListView mListView03;
    protected MyListItem myListItem;
    private TextView Text01Sum; // 残高合計
    private static SQLiteDatabase db;
    
    // 参照するDBのカラム
    private String[] columns = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DBAdapterのコンストラクタ呼び出し
        dbAdapter = new DBAdapter(this);

        // itemsのArrayList生成
        items = new ArrayList<>();

        // MyDaseAdapterのコンストラクタ呼び出し
        myBaseAdapter = new MyBaseAdapter(this, items);

        // 残高合計を格納
        Text01Sum = (TextView) findViewById(R.id.text01Sum);
        loadSum();// 残高合計
         :
         :
         :
    }

    private void loadSum() {

        dbAdapter.openDB(); // DBの読み込み(読み書きの方)
        int amount;

        // DBのデータを取得

        //Cursor c = dbAdapter.getDB(columns);
        Cursor c = db.rawQuery("select sum(price) from banks ;", null);
        if (c.moveToFirst()) {
            do {
                amount = c.getInt(0);
                Text01Sum.setText(amount);
            } while (c.moveToNext());
        }

        c.close();
        dbAdapter.closeDB(); // DBを閉じる
    }

}


----------------------------------------------------------------------------
「DBAdapter.java」ファイル

public class DBAdapter {
    private final static String DB_NAME = "mybank.db"; // DB名
    private final static String DB_TABLE = "banks";    // DBのテーブル名
    private final static int DB_VERSION = 1;           // DBのバージョン

    /**
     * DBのカラム名
     */
    public static final String COL_ID = "_id";                // id
    public static final String COL_BANKNAME = "bankname";     // 銀行名
    public static final String COL_PRICE = "price";           // 残高
    public static final String COL_NOTE = "note";             // メモ
    public static final String COL_LASTUPDATE = "lastupdate"; // 更新日

    private SQLiteDatabase db = null; // SQLiteDatabase
    private DBHelper dbHelper = null; // DBHepler
    protected Context context;        // Context

    // コンストラクタ
    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    /**
     * DBの読み書き
     * openDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter openDB() {
        db = dbHelper.getWritableDatabase(); // DBの読み書き
        return this;
    }

    /**
     * DBの読み込み 今回は未使用
     * readDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter readDB() {
        db = dbHelper.getReadableDatabase(); // DBの読み込み
        return this;
    }

    /**
     * DBを閉じる
     * closeDB()
     */
    public void closeDB() {
        db.close(); // DBを閉じる
        db = null;
    }

    /**
     * DBのレコードへ登録
     * saveDB()
     *
     * @param id id
     * @param bankname 銀行名
     * @param price 残高
     * @param note メモ
     * @param lastupdate 更新日
     */
    public void saveDB(String id, String bankname, String price, String note, String lastupdate) {
        db.beginTransaction(); // トランザクション開始

        try {
            ContentValues values = new ContentValues(); // ContentValuesでデータを設定していく
            values.put(COL_ID, id);
            values.put(COL_BANKNAME, bankname);
            values.put(COL_PRICE, price);
            values.put(COL_NOTE, note);
            values.put(COL_LASTUPDATE, lastupdate);

            // insertメソッド データ登録
            // 第1引数：DBのテーブル名
            // 第2引数：更新する条件式
            // 第3引数：ContentValues
            db.insert(DB_TABLE, null, values); // レコードへ登録

            db.setTransactionSuccessful(); // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction(); // トランザクションの終了
        }
    }

    /**
     * DBのデータを取得
     * getDB()
     *
     * @param columns String[] 取得するカラム名 nullの場合は全カラムを取得
     * @return DBのデータ
     */
    public Cursor getDB(String[] columns) {

        // queryメソッド DBのデータを取得
        // 第1引数：DBのテーブル名
        // 第2引数：取得するカラム名
        // 第3引数：選択条件(WHERE句)
        // 第4引数：第3引数のWHERE句において?を使用した場合に使用
        // 第5引数：集計条件(GROUP BY句)
        // 第6引数：選択条件(HAVING句)
        // 第7引数：ソート条件(ODERBY句)
        return db.query(DB_TABLE, columns, null, null, null, null, null);
    }
/** 以下略 */

}
