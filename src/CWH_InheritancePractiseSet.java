public class CWH_InheritancePractiseSet {
    public static void main(String[] args) {
//        q1
        Cylinder1 c1 = new Cylinder1();
        c1.setRadius(4);
        c1.setHeight(5);
//        System.out.println(c1.getRadius());
//        System.out.println(c1.getHeight());
        System.out.println(c1.findSA());
        System.out.println(c1.findVol());
//        q2
        Cuboid cu = new Cuboid();
        cu.setLength(4);
        cu.setBreadth(5);
        cu.setHeight(6);
//        System.out.println(cu.getLength());
//        System.out.println(cu.getBreadth());
//        System.out.println(cu.getHeight());
        System.out.println(cu.findArea());
        System.out.println(cu.findVol());
    }
}
// Q1
class Circle{
    int radius;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
class Cylinder1 extends Circle{
    int height;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    float findSA(){
        return (float)((2*Math.PI*radius*radius)+(2*Math.PI*radius*height));
    }
    float findVol(){
        return (float)(Math.PI*radius*radius*height);
    }


}
//q2
class Rectangle5{
    int length;
    int breadth;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}
class Cuboid extends Rectangle5{
    int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    int findArea(){
        return (2*length*breadth)+(2*length*height)+(2*height*breadth);
    }
    int findVol(){
        return length*breadth*height;
    }
}
