import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Main {
    public static void main(String[] args) throws Exception {
        String start = "2019/02/24 16:30";  // 始業
        String end   = "2019/02/25 00:30";  // 終業

        // 日時のフォーマットを定義して、上記の文字列をLocalDateTime型にする
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime date1 = LocalDateTime.parse(start, fmt);
        LocalDateTime date2 = LocalDateTime.parse(end  , fmt);
        
        // 二つの時刻の差を「分」で取得
        long mm = ChronoUnit.MINUTES.between(date1, date2);

        // 働いてる時間をLocalTime型にする
        LocalTime work = LocalTime.ofSecondOfDay(mm * 60);
        
        // 休憩時間1時間を引く
        work = work.minusHours(1);
        
        System.out.println(work);
        // androidなら以下でTextViewに設定できる
        // TextView#setText(wrok.toString());
    }
}
