public class Main {
    public static void main(String[] args) {
        // v1 = (2, 3)定義
        Vector v1 = new Vector();
        v1.x = 2;
        v1.y = 3;
        System.out.println("v1 = " + v1);

        // v2 = (3, 4)定義
        Vector v2 = new Vector();
        v2.x = 3;
        v2.y = 4;
        System.out.println("v2 = " + v2);

        // ベクトル和：v1 + v2
        v1.add(v2);
        System.out.println("v1 = " + v1);

        // ベクトル内積：v1・v2
        int product = v1.product(v2);
        System.out.println("product = " + product);
   }
}

class Vector {
    public int x, y;
    public void add(Vector v) {
        x += v.x;
        y += v.y;
    }
    
    public int product(Vector v) {
        return x * v.x + y * v.y;
    }

    @Override public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
