import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

class Main {

    public static void main(String[] args) {

        // 変換対象Jsonデータ
        String script = "{\"りんご\":\"apple\", \"みかん\":\"orange\"}";
        System.out.println("変換データ：" + script);

        try {
            // エンジン起動して、実行
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Object obj = engine.eval("(" + script + ")");
            Map<String, Object> map = (Map<String, Object>)obj;

            // map中身確認
            System.out.println("りんご : " + map.get("りんご"));
            System.out.println("みかん : " + map.get("みかん"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
