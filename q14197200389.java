class Kadai04_4
  {
    public static void main(String[] args)
      {
        long start = System.currentTimeMillis();

        int answer = new java.util.Random().nextInt(100);        // ①
        System.out.println("数字を当ててください(0から99まで)"); // ②
        java.util.Scanner sc = new java.util.Scanner(System.in);
        for(int count = 1, diff = -1; diff != 0; count++) {      // ⑤
          int input = sc.nextInt();                              // ③

          // 答えと入力値の差から表示物判定
          diff = answer - input;
          if (diff >  0) System.out.println(input + "より大きいです");       // ④
          if (diff <  0) System.out.println(input + "より小さいです");       // ④
          if (diff == 0) System.out.println(count + "回目で正解しました！"); // ⑥
        }

        long end = System.currentTimeMillis();
        System.out.println("正解までの時間は" + (end - start)/1000.0 + "秒でした");
    }
}
