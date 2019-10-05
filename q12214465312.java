import java.util.Random;

/** 【RandomNumber】 */
public class RandomNumber {
    private int randMax = 2;
    public RandomNumber(){
    int max;
    RandomNumber max = new RandomNumber();
    if (max >= 3) {
        randMax = x;
    }

    double getNum(){
        return r.nextDouble();
    }

    Random r = new Random(){
        n = (int r) * (int randMax);
        randMax++;
    }





/*【ConfirmingRandom】*/
class ConfirmingRandom {
    public static void main(String[] args) {
        RandomNumber rnd = new RandomNumber(10);

        ConfirmingRandom[] count = new ConfirmingRandom[10];

        for (int i = 0; i <10000; i++) {
            double r = rnd.nextDouble();
        }

        System.out.println("[出現回数]");

        for (int i =0; i <10; i++) {
            System.out.println((i+1)+":"+ rnd.nextDouble());
        }
    }
