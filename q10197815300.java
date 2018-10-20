public class Main {
    public static void main(String[] args) {
        // 乱数で行列Hを作る
        java.util.Random r = new java.util.Random();
        int[][] H = java.util.stream.IntStream.range(0, 20) // 列：20個作る
            .mapToObj(n -> r.ints(20, -30, 30).toArray())   // 行：20個作る(-30～30までの乱数)
            .toArray(int[][]::new);                         // 二次元配列として生成

        // 行列Hの中身を確認(なくてもいい)
        java.util.Arrays.stream(H)
        .forEach(row -> System.out.println(java.util.Arrays.toString(row)));

        // 何番目までのデータがほしいのか決める
        System.out.print("何番目までのデータがほしい？ > ");
        int num = new java.util.Scanner(System.in).nextInt();

        // 行列をDataリストに変換
        java.util.List<Data> list = new java.util.ArrayList<>();
        for(int i = 0; i < H.length; i++) {
            for(int j = 0; j < H[i].length; j++) {
                // +1の理由：配列の要素番号は「0」開始だが、
                // 数学の行列の要素番号は「1」開始の為、オフセットが必要
                list.add(new Data(j + 1, i + 1, H[i][j]));
            }
        }

        // 要件を満たすデータを配列にして取得
        Data[] terget = list.stream()
        .sorted((e1,e2) -> e2.value - e1.value) // 値で降順ソート
        .limit(num)                             // 上からnum番目までを取り出す
        .toArray(Data[]::new);                  // 配列にする

        // 作ったデータ配列を確認(なくてもいい)
        java.util.Arrays.stream(terget).forEach(System.out::println);
    }
}

/**
 * 行と列と値を持つデータクラス
 */
class Data {
    final int x, y, value;
    Data(int x, int y, int v) {this.x = x; this.y = y; this.value = v;}
    public String toString(){return String.format("%d行%d列目:要素%d", y, x, value);}
}
