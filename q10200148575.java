import java.time.LocalDate;

class Main {
    public static void main(String args[]) {
        Example example = new Example(20200502);
        int diff = example.getDate(20190401);
        System.out.println(diff);
    }
}

class Example {
    final int date;
    Example(int date) {
        this.date = date;
    }

    /**
     * メンバ変数と引数の日の差を求める
     * @param date 目標の日
     * @return メンバ変数と引数の日の差
     */
    int getDate(int date) {
        LocalDate d1, d2;
        // メンバ変数をLocalDate化
        d1 = LocalDate.parse(String.valueOf(this.date).replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3"));
        // 引数をLocalDate化
        d2 = LocalDate.parse(String.valueOf(date).replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3"));

        // 日付を増やしていくか、減らしていくか
        int dt = d1.compareTo(d2) > 0 ? 1 : -1;

        // カウントしていく
        int cnt = 0;
        while (!d1.equals(d2)) { // 日付が一致すればカウント終了
            // 次の日に移動
            d2 = d2.plusDays(dt);

            // うるう日(2月29日)ならカウントしない
            if (d2.getMonthValue() == 2 && d2.getDayOfMonth() == 29) continue;

            // カウント更新
            cnt += dt; // 日の差の絶対値でいいなら「cnt++」
        }
        return cnt;
    }
}
