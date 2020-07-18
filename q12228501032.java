import java.util.Map;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws Exception {
        java.util.Map<Key, String> map = new HashMap<>();
        map.put(new Key(1), "a"); // Key1を生成して、"a"を格納
        map.put(new Key(2), "b"); // Key2を生成して、"b"を格納
        map.put(new Key(1), "c"); // Key1を生成して、"c"を上書き

        // マップの中身を全出力して、Key(1)が上書きされていることを確認
        System.out.println(map);

        // getメソッドで、Key(1)が取れていることを確認
        System.out.println(map.get(new Key(1)));
    }
}

class Key {
    final int hashCode;
    Key(int code) { hashCode = code;}

    /** 同値確認　フィールドのhashCodeが同じなら、同じと判断する */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Key) ? ((Key)o).hashCode == this.hashCode : false;
    }

    /** ハッシュコード生成 ハッシュコードはフィールドの変数とする */
    @Override
    public int hashCode() { return this.hashCode; }
}
