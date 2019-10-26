public class Main {
    public static void main(String[] args) {
        // v1 = (2, 3)定義
        Vector v1 = new Vector();
        v1.x = 2;
        v1.y = 3;
        v1.show();

        // v2 = (3, 4)定義
        Vector v2 = new Vector();
        v2.x = 3;
        v2.y = 4;
        v2.show();

        // ベクトル和：v1 + v2
        v1.add(v2);
        v1.show();

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

    public void show() {
        System.out.printf("(%d, %d)%n", x, y);
    }
}
