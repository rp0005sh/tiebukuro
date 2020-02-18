class Main {
    /** 列挙体で手を定義 */
    enum COMMAND {
        /** グーを定義（グーはチョキに勝つと定義)*/
        グー   {boolean isWin(COMMAND cmd) {return cmd == チョキ;}},
        /** チーを定義（チョキはパーに勝つと定義)*/
        チョキ {boolean isWin(COMMAND cmd) {return cmd == パー;}},
        /** パーを定義（パーはグーに勝つと定義)*/
        パー   {boolean isWin(COMMAND cmd) {return cmd == グー;}};
        /** 自分は勝っているかチェック */
        abstract boolean isWin(COMMAND cmd);
        /** 判定 */
        String judge(COMMAND cmd) {return this.isWin(cmd) ? "かち" : cmd == this ? "あいこ" : "まけ";};
    }

    public static void main(String[] args) {
        COMMAND cmd1 = COMMAND.グー;
        COMMAND cmd2 = COMMAND.パー;
        String judge = cmd1.judge(cmd2);

        // 結果表示
        System.out.println(cmd1 + " vs " + cmd2);
        System.out.println(cmd1 + "の" + judge);
    }
}
