public class CWH_CH9P {
    public static void main(String[] args) {
    /* Q1 and Q2
    Cylinder c1 = new Cylinder();
    c1.setRadius(5);
    c1.setHeight(4);
    System.out.println(c1.getRadius());
    System.out.println(c1.getHeight());
    System.out.println(c1.findSA());
     */
    /*
    Q3
    Cy c1 = new Cy(5,4);
    c1.Cyy();
     */
    Rectangle1 r1 = new Rectangle1(5,4);
    System.out.println(r1.getLength());
    System.out.println(r1.getBreadth());
    Sphere s1 = new Sphere();
    s1.setRadius(5);
    System.out.println(s1.getRadius());
    }
}
//Q1 : create a class cylinder and use getters and setters to set its
//radius and height
class Cylinder{
    private int radius;
    private int height;
    void setRadius(int radius){
        this.radius=radius;
    }
    void setHeight(int height){
        this.height=height;
    }
    int getRadius(){
        return radius;
    }
    int getHeight(){
        return height;
    }
//    find its surface area (A = 2πr² + 2πrh)
    float findSA(int height, int radius){
        return (float)((2*Math.PI*radius*radius)+(2*Math.PI*radius*height));
    }
}
// perform Q1 by using constructor
class Cy{
    private int radius;
    private int height;
    public Cy(int radius, int height){
        this.radius=radius;
        this.height=height;
    }

    public int getRadius() {
        return radius;
    }

    public int getHeight() {
        return height;
    }
}
// Overload a constructor used to initialise a rectangle of length 4
//and breadth 5 for using custom parameters
class Rectangle1{
    int length;
    int breadth;
    public Rectangle1(){
        length = 4;
        breadth = 5;
    }
    public Rectangle1(int l, int b){
        length = l;
        breadth = b;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }
}
class Sphere {
    private int radius;
    void setRadius(int radius) {
        this.radius = radius;
    }
    int getRadius() {
        return radius;
    }
}
