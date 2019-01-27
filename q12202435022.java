/** Personをインスタンス化するクラス */
class Question13_1 {
    public static void main(String[] args) {
        // Personをインスタンス化
        Person p = new Person();
        p.setName("あああ");

        // Humanクラスのメンバをすべて使用(表示)するプログラム
        System.out.println("name\t= " + p.getName());
        System.out.println("age\t= " + p.age);
        System.out.println("height\t= " + p.height);
        System.out.println("weight\t= " + p.weight);
    }
}


/** Humanを継承したPersonクラス */
class Person  extends Human{};

/** Humanクラス */
class Human {
    private String name = "デフォルトの名前";
    protected int age = 22;
    public int height = 170;
    final public int weight = 55;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
