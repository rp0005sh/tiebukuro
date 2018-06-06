public class test2202 {
    public static void main(String[] args) {

        Ex2202_ShohinTable n = new Ex2202_ShohinTable();

        Ex2202_Shohin te;
        int i = 0;

        while ((te = n.getS(i)) != null) {
            System.out.println("品番：" + te.品番 + " 品名：" + te.品名 + " 単価：" + te.単価);
            i++;
        }


       final java.util.Scanner sc = new java.util.Scanner(System.in);
       while (true) {
           // 品番入力、終了チェック処理
           System.out.print("品番を入力してください(End:0)＞");
           int 品番  = sc.nextInt();
           if (品番 == 0) break;

           // 商品検索して表示する処理
           Ex2202_Shohin 商品 = n.商品検索(品番);
           if (商品 == null) {
               System.out.println("品番が間違っています");
               continue;
           }
           System.out.println("品名：" + 商品.品名);
           
           // 数量入力処理
           System.out.print("数量を入力してください＞");
           int 数量  = sc.nextInt();
           if (数量 == 0) continue; // 数量は利用は0ならエラーって書いてるけど、なにするの？とりあえず品番入力まで戻る
           System.out.println("金額：" + 商品.単価 * 数量);
       }
    }
}

class Ex2202_ShohinTable {

    public Ex2202_Shohin[] ad;

    Ex2202_ShohinTable() {
        int[] hinban = { 1001, 1002, 2001, 2002, 3001 };
        int[] tanka = { 105, 147, 630, 525, 1365 };
        String[] hinmei = { "消しゴム", "ボールペン", "バインダー", "分度器", "コンパス" };
        ad = new Ex2202_Shohin[hinban.length];

        for (int i = 0; i < hinban.length; i++) {
            Ex2202_Shohin t = new Ex2202_Shohin(hinban[i], tanka[i], hinmei[i]);
            ad[i] = t;
        }
    }

    public Ex2202_Shohin getS(int s) {
        if (s < 0 || s > ad.length - 1) {
            return null;
        } else {
            return ad[s];
        }
    }

   /** 
    * 品番を検索して、あれば内容を返す。
    * なければ、nullを返す
    */
   public Ex2202_Shohin 商品検索(int 品番) {
       Ex2202_Shohin 検索結果 = null;
       for (Ex2202_Shohin shohin : ad) {
           if (shohin != null && shohin.品番 == 品番) {
               検索結果 = shohin;
               break;
           }
       }
       return 検索結果;
   }
}

class Ex2202_Shohin {
    int 品番, 単価;
    String 品名;

    Ex2202_Shohin(int a, int b, String c) {
        品番 = a;
        品名 = c;
        単価 = b;
    }
}
