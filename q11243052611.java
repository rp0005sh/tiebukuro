import java.util.ArrayList;
import java.util.Scanner;
import static java.util.Comparator.naturalOrder;

class Main {
  public static void main(String[] args) {
    ArrayList<Integer> number = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    for (int i = 0;i < 10; i++) {
      System.out.println("整数を入力してください");
      int num = scan.nextInt();
      number.add(num);
    }
    number.sort(naturalOrder());
    System.out.println(number);
  }
}
