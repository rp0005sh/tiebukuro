class sample {
    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        String result;
        // 入力が１ならそのまま
        if (target == 1) {
            result = "1";
        }
        // 素因数分解してフォーマットを整える
        else {
            result = func(target).entrySet().stream()
                .sorted((e1, e2) -> e1.getKey() - e2.getKey())       // 小さい順に並び替える
                .map(el -> el.getKey() + "^" + el.getValue())        // n^mの形にフォーマット変更
                .collect(java.util.stream.Collectors.joining(" * "));// それぞれの因数を「*」でつなぎ合わせる
        }
        
        // 結果出力
        System.out.println(target + " = " + result);
    }

    /** 引数の数値を素因数分解する（Keyが素因数。Valueが割れる回数） */
    static java.util.Map<Integer, Integer> func(int n) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        // 因数の分だけ繰り返す
        for (int i = 2; i <= n; i++) {
            //割り切れるなら因数
            if (n % i == 0) {
                //要素を取り出してカウントを加算し、格納しなおす
                int cnt = map.getOrDefault(i, 0) + 1; 
                map.put(i, cnt);

                // チェック完了したので、因数で割る
                n /= i; 

                // もし、対象が1になったら、もう因数は存在しないので終了
                if (n == 1) break;
                
                // もう一度同じ因数で割れるかもしれないので、ループカウントを戻して、再度チェック
                else i--;
            }
        }
        return map;
    }
}
