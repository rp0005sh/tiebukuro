class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bar_chart.apply {
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            // X軸
            val xValues = listOf("0:00", "0:30", "1:00", "1:30", "2:00", "2:30")
            // データ設定
            val valuesDataSet = BarDataSet(listOf(
                BarEntry(100f, 0),
                BarEntry(200f, 1),
                BarEntry(300f, 2),
                BarEntry(200f, 3),
                BarEntry(100f, 4),
                BarEntry(50f, 5)), "Data")
            data = BarData(xValues, valuesDataSet)
        }
    }
}
