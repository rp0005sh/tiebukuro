class Main {
    public static void main(String[] args) {
        // (1).int 型の変数 year を用意し、任意の年を代入し、表示する。
        int year = 2020;
        System.out.println(year);

        // (2).boolean 型の変数 isleap を用意する。 
        boolean isleap;

        // (3).year が閏年なら isleap を true に、平年なら false にする。 
        isleap = isLeap(year);

        // (4).isleap が true の時「閏年」、false の時「平年」と表示する。 
        System.out.println(isleap ? "閏年" : "平年");

    }
    // (5).条件判断には条件演算子を使用する
    static boolean isLeap(int year) {
        // （１）400で割り切れればうるう年決定
        if (year % 400 == 0) return true;
        // （２）（１）それに該当せず100で割り切れれば平年決定。
        if (year % 100 == 0) return false;
        // （３）（１）（２）どちらにも該当せず、４で割り切れればうるう年決定、割り切れなければ平年決定
        if (year % 4 == 0) return true;
        else               return false;
    }
}
