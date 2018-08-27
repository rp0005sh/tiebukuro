public class Main {
    public static void main(String[] args) {
        // マップのインスタンスを作る
        // 単語の並び順を考慮するなら、このインスタンスを調整するが、仕様が不明なのでHashMapで
        java.util.Map<String, Integer> map = new java.util.HashMap<>();

        // スペース区切りの単語群を1行読み込んで、単語ごとに配列にまとめる
        String[] words = new java.util.Scanner(System.in).nextLine().split(" ");
        
        // 取得した単語の数だけループして、単語ごとにカウントしていく
        for (String w : words) {
            int count = map.getOrDefault(w, 0);
            map.put(w, count + 1);
        }

        // 出力
        System.out.println("*******************");
        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("*******************");
    }
}
