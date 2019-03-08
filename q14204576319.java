public class Main {
    public static void main(String[] args) {
        int value = 20080805;
        func(value);
    }

    /**
     * 日付用にスラッシュで編集
     * @param value 変換対象
     */
    static public void func(int value) {
        // 変換処理
        String date;
        if (String.valueOf(value).length() != 8) date = "8桁で入力してください";
        else  date = String.valueOf(value).replaceAll("(\\d{4})(\\d{2})(\\d{2})","$1/$2/$3");

        // 出力
        System.out.println(date);
    }
}
