public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // それぞれのView取得
        CompactCalendarView cView =  findViewById(R.id.calendar);
        TextView tView = findViewById(R.id.textView);
        
        // カレンダーにクリック処理をつける
        cView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {            
                DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
                tView.setText(sdf.format(dateClicked));
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {}
        });
    }
}
