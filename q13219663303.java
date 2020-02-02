class Main {
    /** メニュー */
    private enum Menu {
    // +----+----------------+----------------+--------+
    // | No | 食品名         | カロリー(kcal) | 塩分(g)|
    // +----+----------------+----------------+--------+
        No1("ざるそば"       ,       340      ,  2.9f  ),
        No2("サンマ定食"     ,       642      ,  5.3f  ),
        No3("天ぷら定食"     ,       829      ,  7.0f  ),
        No4("醤油ラーメン"   ,       510      ,  5.3f  ),
        No5("のり弁当"       ,       688      ,  4.0f  ),
        No6("幕の内弁当"     ,       802      ,  4.8f  ),
        No7("唐揚げ弁当"     ,       748      ,  3.8f  ),
        No8("ハンバーガー"   ,       250      ,  1.2f  ),
        No9("チーズバーガー" ,       300      ,  1.7f  ),
        No10("にぎり寿司(並)",       440      ,  2.6f  );
    // +----+----------------+----------------+--------+
        private final String name;
        private final float cal,salt;
        Menu(String name, float cal, float salt) {
            this.name = name;
            this.cal  = cal;
            this.salt = salt;
        }
    }
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.List<Menu> list = new java.util.ArrayList<>();

        // 入力処理
        while (true) {
            System.out.print("番号入力 > ");
            try {
                Menu menu = Menu.valueOf("No" + sc.nextInt());
                list.add(menu);
                System.out.printf("「%s」が入力されました%n", menu.name);
            } catch(IllegalArgumentException | java.util.InputMismatchException e) {
                System.out.printf("存在しない番号が入力されました%n終了します%n%n");
                break;
            }
        }

        // 結果の出力処理
        System.out.printf("合計%nカロリー: %3.0f [kcal]\t塩分: %3.2f [g]%n"
            , list.stream().mapToDouble(m -> m.cal).sum()
            , list.stream().mapToDouble(m -> m.salt).sum());
    }
}
