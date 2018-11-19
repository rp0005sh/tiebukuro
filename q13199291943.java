public class Main {
    public static void main(String[] args) {
        // 0から9の乱数を50個発生させ、配列にする
        int[] rand = new java.util.Random().ints(50, 0, 10).toArray();

        // 繰り返し文で乱数を一つずつ足していき、100を超えるところをチェック
        int sum = 0, i;
        for(i = 0; i < rand.length; i++) {
            int tmp = sum + rand[i]; // 乱数を一つ足す
            if (tmp > 100) break;    // 100を超えるかチェック。超えてたら終了
            else sum = tmp;          // 100を超えていなければ、合計値を更新
        }
        
        // 結果を出力
        System.out.println(i < rand.length
            ? (i + 1) + "番目で100を超える。100を超える前の合計は" + sum
            : "全部足しても100を超えない");
    }
}
