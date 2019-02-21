public class Main {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Random rand = new java.util.Random();
        int num1 = rand.nextInt(13) + 1, num2 = rand.nextInt(13) + 1;

        System.out.println("High＆Low");
        System.out.println(num1 + " ?");

        System.out.print("HかLを入力してください>");
        String ans = sc.next();

        System.out.println("High＆Low");
        System.out.println(num1 + " " + num2);

        switch(ans) {
            case "L":
                System.out.println("あなたはLowを選びました。");
                System.out.println(num2 < num1 ? "You Win！" : "You Lose");
                break;
            case "H":
                System.out.println("あなたはHighを選びました。");
                System.out.println(num2 > num1 ? "You Win！" : "You Lose");
                break;
            default:
                System.out.println("入力値不正。「H」か「L」以外が入力されました。");
        }
    }
}
