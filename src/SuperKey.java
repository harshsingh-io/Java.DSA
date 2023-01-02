public class SuperKey {
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}
class Animal{
        String color;
    Animal(){
        System.out.println("Animal constructor called");
    }
}
class Horse extends Animal{
    Horse(){
        super.color = "Brown";
        System.out.println("Horse constructor called");
    }
}
