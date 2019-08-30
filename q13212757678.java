for (int i = 1; i <= h; i++) {
    for (int j = 1; j <= w; j++) {
        int p = sc.nextInt();
        if (p >= 128) { // 128以上は白
            System.out.print("1");
        } else if (p <= 127) { // 127以下は黒
            System.out.print("0");
        }
        
        // 行の末尾の数値でなければスペースを入れておく
        if (j != w) {
            System.out.print(" ");
        }
    }
    System.out.println();
}
