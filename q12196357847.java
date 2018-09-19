public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // CalendarViewにリスナーを設定
       ((CalendarView) findViewById(R.id.calendarview)).setOnDateChangeListener(listener);
    }

    /**
     * カレンダーの日付部分タップ時のリスナー
     */
    CalendarView.OnDateChangeListener listener = new CalendarView.OnDateChangeListener() {

        /**
         * 日付部分タップ時に実行される処理
         * @param view 押下されたカレンダーのインスタンス
         * @param year タップされた日付の「年」
         * @param month タップされた日付の「月」※月は0月から始まるから、+1して調整が必要
         * @param dayOfMonth タップされた日付の「日」
         */
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            // とりあえずトースト表示してみる
            Toast.makeText(getApplicationContext(), year + "年" + (month + 1) + "月" + dayOfMonth + "日がクリックされました", Toast.LENGTH_SHORT).show();

            // TODO:
            // 引数の year, month, dayOfMonthを利用して、DBから予定表を取得
            // ListViewに予定表リストを突っ込む
        }
    };
}
