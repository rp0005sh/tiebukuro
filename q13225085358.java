class AtodashiJanken {
    public static void main(String[] args) {
        // 1.randomな数値を生成して、変数に退避しておきます。
        int npc = new java.util.Random().nextInt(3);

        // 2.生成されたランダムな数値を元に「0:グー, 1:チョキ, 2:パー」を画面表示します。
        Object[] cmd = {"グー", "チョキ","パー"};
        System.out.printf("NPCの手は%d:%s%n", npc, cmd[npc]);

        // 3.「何を出しますか？(0:グー, 1:チョキ, 2:パー)」のように画面表示し、数値を入力させます。
        System.out.printf("何を出しますか？(0:%s, 1:%s, 2:%s)%n", cmd);
        int you = new java.util.Scanner(System.in).nextInt();

        // 4.入力された数値と、１で生成されたランダムな数値で、勝敗を判定します。
        if (0 <= you && you <= 2) {
            int judge = (npc - you + 3) % 3;
            System.out.print(judge == 0 ? "あいこ" : judge == 1 ? "勝ち" : "負け");
        }

        // 5.入力された値が0,1,2のどれでもない場合は、「あなたの出した手が判断できません。勝負はしません。」
        // というメッセージを出力し、プログラムを終了してください。
        else {
            System.out.println("あなたの出した手が判断できません。勝負はしません。");
        }
    }
}
