public class Main {
    public static void main(String[] args) {
        java.util.Map<String, String> map = new java.util.HashMap<>();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // データ入力処理
        while (true) {
            // 名前入力
            System.out.print("名前入力 -> ");
            String key = sc.nextLine();
            if (key.equals("end")) break; // 「end」だったら終了
            
            // 出身地入力
            System.out.print("出身地入力 -> ");
            String value = sc.nextLine();
            if (value.equals("end")) break; // 「end」だったら終了

            // mapに名前と出身地を紐づけて記録(同一名の人がいた場合、出身地は上書きされる)
            map.put(key, value);
        }

        // mapに保存されているデータを出力していく
        for (java.util.Map.Entry<String, String> e : map.entrySet()) {
            String name = e.getKey(), from = e.getValue();
            System.out.println("名前："+name + ", 出身地：" + from);
        }
    }
}
