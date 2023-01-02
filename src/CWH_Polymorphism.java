class CellPhone2{
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
interface Camera2{
    void clickpicture();
}
interface mediaPlayer2{
    void playMedia();
}
interface gps2{
    void gps();
}
class MySmartphone extends CellPhone2 implements Camera2,mediaPlayer2,gps2{
    @Override
    public void clickpicture() {
        System.out.println("Taking Snaps");
    }

    @Override
    public void playMedia() {
        System.out.println("Playing Music");
    }

    @Override
    public void gps() {
        System.out.println("Turning On GPS");
    }
}
public class CWH_Polymorphism {
    public static void main(String[] args) {
        gps2 g = new MySmartphone();
        g.gps();
//        g.clickpicture(); --> not allowed
    }
}
