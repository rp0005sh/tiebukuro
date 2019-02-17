class Main {
    public static void main(String[] args) {

        // テストデータの設定、表示
        String week = "日";
        System.out.println("week = " + week);

        // メソッドの呼び出し、戻り値の表示
        boolean b = kyuujituHantei(week);  // 一回boolean型で格納
        String result = String.valueOf(b); // boolean型からString型へ変換
        System.out.println("result = " + result); 
    }

    public static boolean kyuujituHantei(String week) {

        // 変数resultを宣言する
        boolean result;

        // weekが土または日の場合
        if (week.equals("日") || week.equals("土")) {

            // trueを格納する
            result = true;

        // 上記以外 
        } else {

            // falseを格納する
            result = false;

        }

        // 結果を返す
        return result;

    }
}
