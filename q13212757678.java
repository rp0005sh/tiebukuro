for (int i = 1; i <= h; i++) {

    // 1行分の表示する文字列を保持する変数定義
    String str = "";

    for (int j = 1; j <= w; j++) {
        int p = sc.nextInt();
        if (p >= 128) { // 128以上は白
            str = str + "1"; // 変数に「１」を追加
        } else if (p <= 127) { // 127以下は黒
            str = str + "0"; // 変数に「0」を追加
        }

        // 要素間のスペースを入れる
        if (j != w) { // 行の末尾は入れないので、j が wと一致するときは行わない
            str = str + " ";
        }
    }

    // 一行分のデータを出力する
    System.out.println(str);
}
