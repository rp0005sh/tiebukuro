import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("(?<=^SET \\d)"); // 右記の配列に変換str = {"SET X", " 数値"}
        int a = 0, b = 0;
        switch(str[0]) {
            case "SET 1" : a = Integer.parseInt(str[1].substring(1)); break;
            case "SET 2" : b = Integer.parseInt(str[1].substring(1)); break;
            default: throw new RuntimeException("不整入力");
        }
        System.out.printf("%d %d", a, b);
    }
}
