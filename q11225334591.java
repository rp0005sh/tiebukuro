class TestObject {
    public static void main(String[] args) {
        // TestObject class should instantiate one rectangle and one box.
        Rectangle rectangle = new Rectangle(8, 4);
        Box box = new Box(5);

        // It should print the value of the length of sides and the perimeter of each object.
        System.out.printf("The circumference of a rectangle measuring %f cm in height and %f cm in width is %f cm.%n",
            rectangle.getLength(), rectangle.getHeight(), rectangle.calcVolume());
        System.out.printf("The circumference of a %f cm box is %f cm.%n",
            box.getSide(), box.calcVolume());
    }
}

class Rectangle {
    double length = 0;
    double height = 0;
    public Rectangle(double l, double h) {
        length = l;
        height = h;
    }

    double calcVolume(){
        double lengthofthesides = length * 2 + height * 2;
        return lengthofthesides;
    }
    
    // Methods returning the length of the sides should be created as well.
    double getLength() { return length;}
    double getHeight() { return height;}
}

class Box {
    double side;
    // You should define constructors to accept and initialize the sides.
    Box(double side) {
        this.side = side;
    }
    // Box class should include a method that calculates and returns the perimeter of the object.
    double calcVolume(){
        double lengthofthesides = side * 4;
        return lengthofthesides;
    }
    
    // Methods returning the length of the sides should be created as well.
    double getSide() { return side;}
}
