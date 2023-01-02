// Object-Oriented Programming Topic is interview point of view
public class OOPs {
    public static void main(String[] args) {
        Pen p1 = new Pen(); //created pen object called p1
        p1.setColor("Blue"); //set colour fun
        p1.setTip(5); //set tip fun
        System.out.println(p1.color);
        System.out.println(p1.tip);
        p1.setTip(2);
        System.out.println(p1.tip);
    }
}
class Pen{ //creating class
    String color; //properties
    int tip; //properties
    void setColor(String newColor){ //fun of object
        color = newColor;
    }
    void setTip(int newTip){ //fun of object
        tip = newTip;
    }
}