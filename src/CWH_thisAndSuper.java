class EkClass {
    int a;
    public int getA() {
        return a;
    }
    EkClass(int a){
        this.a = a;
        System.out.println(this.a);
    }
    public int returnone(){
        return 1;
    }
}
class DoClass extends EkClass {
    DoClass(int c){
    super(c);
    System.out.println("I am a constructor");
    }
}
public class CWH_thisAndSuper {
    public static void main(String[] args) {
        EkClass e = new EkClass(65);
        DoClass d = new DoClass(05);
//      System.out.println(e.getA());
    }
}
