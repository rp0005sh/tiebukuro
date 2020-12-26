/* java側ソースコード */

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    SharedPreferences spf;
    static final String KEY = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 今日の日にち取得
        LocalDate date = LocalDate.now();

        // SharePreferenceから保存Date読み込み
        spf = getSharedPreferences("date", MODE_PRIVATE);
        String load = spf.getString(KEY, date.toString()); //保存データがなければ今日の日にちを設定
        LocalDate saveDate = LocalDate.parse(load);

        // 保存データが翌日以降であるならセーブデータを消す
        if (date.compareTo(saveDate) < 0) {
            spf.edit().clear().apply();
            saveDate = date; //カレンダーに表示する情報も今にする
        }

        // カレンダーに表示
        setCalendar(saveDate);
    }

    /** EditTextの内容をSharedPreferenceに保存する */
    public void onClickSaveButton(View v) {
        try {
            // 入力値の抜き出し
            String inputDate = ((TextView)findViewById(R.id.editTextDate)).getText().toString();

            // フォーマットが正しいかチェック
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate targetDate = LocalDate.parse(inputDate, formatter);

            // 保存処理
            spf.edit().putString(KEY, targetDate.toString()).apply();

            // カレンダーに表示
            setCalendar(targetDate);
        } catch(Exception e) {
            // 失敗したらエラーを表示
            Toast.makeText(this, "フォーマットが正しくない", Toast.LENGTH_SHORT).show();
        }
    }

    /** 引数の日をカレンダーに表示する */
    private void setCalendar(LocalDate date) {
        CalendarView cv = findViewById(R.id.calendarView);
        ZonedDateTime zdt = date.atStartOfDay(ZoneOffset.UTC);
        cv.setDate(zdt.toEpochSecond() * 1000L);
    }
}




/* レイアウト側コード */
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextDate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="date"
        android:hint="yyyy/mm/dd"
        app:layout_constraintEnd_toStartOf="@+id/button"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="保存する"
        android:onClick="onClickSaveButton"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/editTextDate"
        app:layout_constraintTop_toTopOf="parent" />

    <CalendarView
        android:id="@+id/calendarView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextDate" />

</androidx.constraintlayout.widget.ConstraintLayout>
