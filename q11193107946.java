/************************************
 * Main.java
 *************************************/
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

    public static void main(String[] args) throws java.io.IOException {
        // 入力データ読み込み
        String script = readAll("json.txt");
        System.out.println("読み込んだファイルの中身：" + script);

        try {
            // エンジン起動して、実行
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Object obj = engine.eval(script);

            // 実行結果の出力
            System.out.println("エンジン実行結果："+ obj + ", class名：" + obj.getClass());

            // Jsonのトークンを配列で取得
            Object[] keys = ((java.util.Set) obj.getClass().getMethod("keySet").invoke(obj)).toArray();

            // トークンとデータを紐づけてMapにマッピングする
            Method method_get = obj.getClass().getMethod("get", Class.forName("java.lang.Object"));
            Map<String, String> map = new HashMap<>();
            for (Object key : keys) {
                Object val = method_get.invoke(obj, key);
                map.put(key.toString(), val.toString());
            }

            // 出力
            System.out.println("MAPの中身 : " + map);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** ファイル名を引数ファイルの中の文字列をすべてStringにして返す */
    public static String readAll(String path) throws java.io.IOException {
        return java.nio.file.Files.lines(java.nio.file.Paths.get(path))
            .reduce("", (prev, line) ->
                prev + line + System.getProperty("line.separator"));
    }
}


/************************************
 * json.txt
 *************************************/
({"0":0, "1":3})
