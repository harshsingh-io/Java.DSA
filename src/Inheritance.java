public class Inheritance {
    public static void main(String[] args) {
//        inheritance
        fish f = new fish();
        f.fins = 4;
        System.out.println(f.fins);
        f.eat();
        f.breathe();
        f.swim();
//   interface inheritance
    horse h = new horse();
    h.moves();
//    multiple interface
    bear b = new bear();
    b.eat_flesh();
    }
}
//interference example
class animal{
    void eat(){
        System.out.println("eating..");
    }
    void breathe(){
        System.out.println("breathing...");
    }
}
class fish extends animal {
    int fins;
    void swim(){
        System.out.println("swimming");
    }
}
class dog extends animal{
    int legs;
    void bark(){
        System.out.println("barking");
    }
}

// interfaces in inheritance
interface chessPlayer{
    void moves();
}
class queen implements chessPlayer{
//    here we defined class as public cause interface should be public final,static.
    public void moves(){
        System.out.println("Queen : up,down,right,left,diagonal in all direction");
    }
}
class king implements chessPlayer{
    public void moves(){
        System.out.println("King : up,down,right,left,diagonal[single step]");
    }
}
class horse implements chessPlayer{
    public void moves(){
        System.out.println("Horse : two step front and then left and right");
    }
}

//multiple inheritance example
interface herbivore{
    void green_veg();
}
interface carnivore{
    void eat_flesh();
}
class bear implements herbivore,carnivore{
    @Override
    public void green_veg() {
        System.out.println("Eats vegetables");
    }

    @Override
    public void eat_flesh() {
        System.out.println("Eat flesh too");
    }
}