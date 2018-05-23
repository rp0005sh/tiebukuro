public class Test
{
  public static void main (String[] args)
  {
    int num1 = 100;
    int num2 = 10;
    int result;

    // 足し算
    result = num1 + num2;
    System.out.println("num1 + num2 = " + result);

    // 引き算
    result = num1 - num2;
    System.out.println("num1 - num2 = " + result);

    // 掛け算
    result = num1 * num2;
    System.out.println("num1 * num2 = " + result);

    // 割り算
    result = num1 / num2;
    System.out.println("num1 / num2 = " + result);

    // 剰余
    result = num1 % num2;
    System.out.println("num1 % num2 = " + result);
  }
}
