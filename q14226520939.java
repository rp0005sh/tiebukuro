import java.util.*;

class Main {
    public static void main(String[] args) {
        // HashMapには名前をキーに要素として趣味のArrayListのインスタンスを格納
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put("太郎", new ArrayList<String>(Arrays.asList("テニス", "スノーボード")));
        map.put("次郎", new ArrayList<String>(Arrays.asList("日曜大工", "料理", "映画鑑賞")));
        map.put("花子", new ArrayList<String>(Arrays.asList("絵画", "スキューバ")));

        // hashMapから反復処理して全てのキー（ここでは名前）を取り出し表示しながら、
        // その要素であるArraListのインスタンスから、反復処理して個々人の全ての趣味を取り出す
        // 表示処理は2重ループ
        for (Map.Entry<String, ArrayList<String>> set : map.entrySet()) {
            System.out.println(set.getKey());
            for(String hobby : set.getValue()) {
                System.out.println("　" + hobby);
            }
        }
    }
}
