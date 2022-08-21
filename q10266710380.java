import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // 入力値を変換
        String[] str = sc.nextLine().split("(?<=^SET \\d)"); // 右記の配列に変換str = {"SET X", " 数値"}
        String command = str[0];
        int num = Integer.parseInt(str[1].substring(1));

        // 仕様の処理
        int a = 0, b = 0;
        switch(command) {
            case "SET 1" : a = num; break;
            case "SET 2" : b = num; break;
            default: throw new RuntimeException("不整入力");
        }
        System.out.printf("%d %d", a, b);
    }
}
