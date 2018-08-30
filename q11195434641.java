public class AsyncTask extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        // 背景色切り替えタスクを実行
        new ChangeBackgroundColorTask(findViewById(R.id.button), 0);
    }
}

/**
 * 背景色切り替えタスクClass
 */
class ChangeBackgroundColorTask extends android.os.AsyncTask<Void, Void, Void>  {
    /** 切り替え対象のView */
    final java.lang.ref.WeakReference<View>  mView;
    /** 切り替える色番号 */
    int num = 0;

    /** コンストラクタ
     * @param view 切り替え対象のView
     * @param num 切り替える色番号
     */
    ChangeBackgroundColorTask(View view, int num) {
        this.mView = new java.lang.ref.WeakReference<>(view);
        this.num = num;
    }

    /** UIスレッド外の処理*/
    @Override
    protected Void doInBackground(Void... arg1) {
        // 3秒待機
        try{Thread.sleep(3000L);}
        catch(InterruptedException e){e.printStackTrace();}
        return null;
    }

    /** doInBackground()後、UIスレッドの処理*/
    @Override
    protected void onPostExecute(Void args2) {
        // 背景色の変更
        int[] colors = new int[3];
        colors[0] = Color.BLUE;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        View v = mView.get();
        if (v != null) {
            if (num == 0) {
                v.setBackgroundColor(colors[0]);
                num++;
            } else
            if (num == 1) {
                v.setBackgroundColor(colors[1]);
                num++;
            } else
            if (num ==2) {
                v.setBackgroundColor(colors[2]);
                num = 0;
            }

            // もう一度タスク開始してループさせる
            new ChangeBackgroundColorTask(v, num).execute();
        }
    }
}
