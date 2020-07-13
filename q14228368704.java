import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

class Main {
    public static void main(String[] args) {
        // 乱数の数値範囲の計算（秒）
        LocalTime start = LocalTime.of( 8, 0); // 08:00から
        LocalTime end   = LocalTime.of(20, 0); // 20:00まで
        int range = (int)Duration.between(start, end).getSeconds();

        // 範囲から乱数を生成
        int r = new java.util.Random().nextInt(range);
        
        // 乱数の時刻完成！
        LocalDateTime rand = LocalDate.now() // 今日の日付取得
                            .minusDays(1)    // 一日引いて昨日にする
                            .atTime(start)   // 時間は8時を設定
                            .plusSeconds(r); // そこから、乱数で取得した秒数を加算

        // フォーマットの形式を合わせて出力
        String result = rand.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(result);
    }
}
