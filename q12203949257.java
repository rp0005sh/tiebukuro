    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 「タイトル１」ダイアログを表示
        final AlertDialog dialog = new AlertDialog.Builder(this).setTitle("タイトル1").setMessage("mes").create();
        dialog.show();

        // 遅らせて「タイトル２」ダイアログを表示
        new android.os.Handler().postDelayed(new Runnable() {
            @Override public void run() {
                // 「タイトル1」ダイアログがまだ表示中なら消去する
                if(dialog.isShowing()) dialog.dismiss();
                // ダイアログを表示
                new AlertDialog.Builder(MainActivity.this).setTitle("タイトル2").setMessage("mes").create().show();
            }
        },5000);// 5秒後に上記をrun()メソッドをUIスレッドで実行させる

    }
