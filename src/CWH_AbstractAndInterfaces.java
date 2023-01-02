// Abstract
abstract class Base {
//    if a class is abstract then its necessary to implement all the abstracted method if it
//    is extended from any child class
    abstract public void greet();
//    abstract public void greet2();
}
class Child extends Base{
    @Override
    public void greet(){
        System.out.println("Good Morning Ji");
    }
}
//Interfaces
interface Bicycle{
    int a = 45; //You cant modify the properties of interface because they are final.
    void applyBrake(int decrement);
    void speedUp(int increment);
}
interface HornBicycle{
    void BlowHorn();
}
class avonCycle implements Bicycle, HornBicycle{
    @Override
//methods of class which use interface should be public
    public void applyBrake(int decrement) {
        System.out.println("Applying Brakes, Speed Now : "+ decrement);
    }

    @Override
    public void speedUp(int increment) {
        System.out.println("Speeding Up, Speed Now :"+ increment);
    }

    @Override
    public void BlowHorn() {
        System.out.println("Side Please...!");
    }
}
class CellPhone{
    public void Call(){
        System.out.println("Calling...");
    }
    public void message(){
        System.out.println("Messaging...");
    }
    public void endCall(){
        System.out.println("Ending Call...");
    }
}
interface Camera{
    void clickpicture();
}
interface mediaPlayer{
    void playMedia();
}
interface gps{
    void gps();
}
class SmartPhone extends CellPhone implements Camera,mediaPlayer,gps{
    @Override
    public void clickpicture() {
        System.out.println("Clicking Picture");
    }

    @Override
    public void playMedia() {
        System.out.println("Opening Media Player");
    }

    @Override
    public void gps() {
        System.out.println("Fetching Your Location");
    }
}

public class CWH_AbstractAndInterfaces {
    public static void main(String[] args) {
//    Child c = new Child();
//    c.greet();
//        avonCycle harshcycle = new avonCycle();
//        harshcycle.applyBrake(2);
//        harshcycle.speedUp(60);
//        System.out.println(harshcycle.a);
//        harshcycle.BlowHorn();
        SmartPhone harshmobile = new SmartPhone();
    }
}
