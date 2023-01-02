public class Polymorphism {
    public static void main(String[] args) {
//        method overloading
        Calculator c = new Calculator();
        System.out.println(c.sum((float) 7.8,(float) 5.6));
        System.out.println(c.sum(5,20));
//        method overriding
        deer d = new deer();
        d.eat();
    }
}
//method overloading
class Calculator{
    int sum(int a, int b){
        int sum=a+b;
        return sum;
    }
    int sum(int a, int b, int c){
        int sum=a+b+c;
        return sum;
    }
    float sum(float a, float b){
        float sum=a+b;
        return sum;
    }
}
//method overriding
class animals{
    void eat(){
        System.out.println("Animal eats");
    }
}
class deer{
    void eat(){
        System.out.println("Deer eats");
    }
}