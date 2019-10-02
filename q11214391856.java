import java.util.Calendar;
import static java.util.Calendar.OCTOBER;
import java.util.Date;

class Main {
    public static void main(String[] args) {

        // 2019/10/1 7:40(火)のオブジェクトを作る
        long time = new Calendar.Builder()
            .setDate(2019, OCTOBER, 1)
            .setTimeOfDay(7, 40, 0).build().getTimeInMillis();
        System.out.println("変換前:" + new Date(time));

        // 加算時間を作る（ミリ秒）
        long addTime = 2 * 24 * 60 * 60 * 1000 // 2日
                         + 15 * 60 * 60 * 1000 // 15時間
                              + 20 * 60 * 1000;// 20分
        // 加算する
        time += addTime;
        
        // 表示
        System.out.println("変換後:" + new Date(time));
    }
}
