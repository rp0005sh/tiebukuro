import java.text.SimpleDateFormat;

class Main {
    public static void main(String[] args) throws Exception {
        String start = "2019/02/24 16:30";  // 始業
        String end   = "2019/02/25 00:30";  // 終業

        // フォーマットを定義し、各時刻をlong型(ミリ秒)にする
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        long date1 = fmt.parse(start).getTime();
        long date2 = fmt.parse(end).getTime();
        long idle  = 60 * 60 * 1000; // 休憩一時間

        // 仕事時間 = 勤務終了 - 勤務開始 - 休憩
        long work = date2 - date1 - idle;

        // [ミリ秒]から[分]に単位変換
        work /= 1000 * 60;

        // 文字に変換[HH:mm]
        String time = String.format("%02d:%02d", work / 60, work % 60);

        System.out.println(time);
        // androidなら以下でTextViewに設定できる
        // TextView#setText(time);
    }
}
