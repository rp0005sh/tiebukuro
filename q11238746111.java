public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 省略
    }

    // ★ここに書く
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        viewborn.setDrawingCacheEnabled(true);
        viewborn.destroyDrawingCache();
        viewborn.buildDrawingCache();
        Bitmap bmpcccc = Bitmap.createBitmap(viewborn.getDrawingCache());
        view888.setImageBitmap(bmpcccc);
    }
}
