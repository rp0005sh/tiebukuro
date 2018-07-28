public class Main {
    public static void main(String[] args) throws Exception {
        String path = "テキストファイル.txt";
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        java.nio.file.Files.lines(java.nio.file.Paths.get(path))
            // ファイルから一行ずつ読み込み
            .forEach(line -> {

                // 日付, 購入品, 値段に分ける(String[0]:日付、String[1]:購入品、String[2]:値段)
                String[] tmp = line.split(",");

                // MAPから日付をキーワードにして、保存データを取得(まだ保存データがない場合は「0」を取得)
                Integer value = map.getOrDefault(tmp[0], 0);

                // 読み込みデータの値段を加算
                value += Integer.parseInt(tmp[2]);
                
                // MAPへ日付をキーワードにして、値段を再設定
                map.put(tmp[0], value);
            });

        // 保存データの出力
        System.out.println(map);
    }
}
