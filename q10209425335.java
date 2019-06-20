import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Main {

    public static void main(String[] args) {
        // 変換前、後のフォーマット定義
        DateTimeFormatter befor = DateTimeFormatter.RFC_1123_DATE_TIME;
        DateTimeFormatter after = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // 変換対象(JST表記はフォーマットで定義されていないので、+0900で置換しておく)
        String terget = "Tue, 20 Feb 2018 00:00:00 JST";
        terget = terget.replace("JST", "+0900");

        // 変換して表示
        String str = LocalDateTime.parse(terget, befor).format(after);
        System.out.println(str);
    }
}
