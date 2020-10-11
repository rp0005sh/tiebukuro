/**
 * MainActivity側の実装
 */
public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    /** ドラッグされたView */
    private View mDragView;
    /** レイアウト */
    private GridLayout mParent;

    /**
     * アプリ起動時の最初に呼ばれるイベント
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 各Viewに、ボタン長押し・ドラッグのイベントを設定していく
        mParent = findViewById(R.id.grid_layout);
        for (int i = 0; i < mParent.getChildCount(); i++) {
            View v = mParent.getChildAt(i);
            v.setOnLongClickListener(this);
            v.setOnDragListener(this);
        }
    }

    /**
     * Viewを長押ししたとき通知されるイベント
     * @param v 対象のView
     * @return イベント有効有無
     */
    @Override
    public boolean onLongClick(View v) {
        // 長押ししているViewをドラッグ状態にする。
        v.startDragAndDrop(null, new View.DragShadowBuilder(v), v, 0);
        mDragView = v;

        // 図（b, c）から、ドラッグ中のViewは見えなくなる必要があるので、透過値調整して消す。
        // Visibilityで消すこともできるが、ドラッグ終了時のアニメーションが入るので、透過値で非表示を表現
        mDragView.setAlpha(0);
        return true;
    }

    /**
     * ドラッグされたとき通知されるイベント
     * @param v 通知を受信したView
     * @param event イベント（使用するのは、ドラッグ終了、ドラッグしたまま他のViewの上にカーソルが合う)
     * @return イベント有効有無(必ずTrueにする)
     */
    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            // 手を放し、ドラッグが終了した時の処理。ドラッグしているViewを表示させる。
            case DragEvent.ACTION_DRAG_ENDED:
                getMainExecutor().execute(() -> mDragView.setAlpha(1));
                break;

            // ドラッグ中他のViewの上に乗る時の処理。Viewの位置を入れ替える
            case DragEvent.ACTION_DRAG_LOCATION:
                getMainExecutor().execute(() -> swap(v, mDragView));
                break;
        }
        return true;
    }

    /**
     * Viewの位置を入れ替える
     * @param v1 入れ替え対象１
     * @param v2 入れ替え対象2
     */
    private void swap(View v1, View v2) {
        // 同じViewなら入れ替える必要なし
        if (v1 == v2) return;

        // レイアウトパラメータを抜き出して、入れ替えを行う
        GridLayout.LayoutParams p1 = (GridLayout.LayoutParams) v1.getLayoutParams();
        GridLayout.LayoutParams p2 =  (GridLayout.LayoutParams) v2.getLayoutParams();
        mParent.removeView(v1);
        mParent.removeView(v2);
        mParent.addView(v1, p2);
        mParent.addView(v2, p1);
    }
}
// ---------------------------------------------------------------------------------------------

/**
 * activity_main.xmlの中身
 */
 <?xml version="1.0" encoding="utf-8"?>

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <GridLayout
        android:id="@+id/grid_layout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:context=".MainActivity">

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="0"
            android:layout_column="0"
            app:srcCompat="@android:drawable/ic_menu_add" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="0"
            android:layout_column="1"
            app:srcCompat="@android:drawable/ic_menu_always_landscape_portrait" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="0"
            android:layout_column="2"
            app:srcCompat="@android:drawable/ic_menu_call" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="0"
            android:layout_column="3"
            app:srcCompat="@android:drawable/ic_menu_camera" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="1"
            android:layout_column="0"
            app:srcCompat="@android:drawable/ic_menu_close_clear_cancel" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="1"
            android:layout_column="1"
            app:srcCompat="@android:drawable/ic_menu_compass" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="1"
            android:layout_column="2"
            app:srcCompat="@android:drawable/ic_menu_crop" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="1"
            android:layout_column="3"
            app:srcCompat="@android:drawable/ic_menu_delete" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="2"
            android:layout_column="0"
            app:srcCompat="@android:drawable/ic_menu_directions" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="2"
            android:layout_column="1"
            app:srcCompat="@android:drawable/ic_menu_directions" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="2"
            android:layout_column="2"
            app:srcCompat="@android:drawable/ic_menu_edit" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="2"
            android:layout_column="3"
            app:srcCompat="@android:drawable/ic_menu_gallery" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="3"
            android:layout_column="0"
            app:srcCompat="@android:drawable/ic_menu_help" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="3"
            android:layout_column="1"
            app:srcCompat="@android:drawable/ic_menu_info_details" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="3"
            android:layout_column="2"
            app:srcCompat="@android:drawable/ic_menu_manage" />

        <ImageView
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_row="3"
            android:layout_column="3"
            app:srcCompat="@android:drawable/ic_menu_recent_history" />
    </GridLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
