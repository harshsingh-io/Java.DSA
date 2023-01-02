 abstract class car {
        static {
            System.out.print("1");
        }
        public car(String name) {
            super();
            System.out.print("2");
        }
        {
            System.out.print("3");
        }
    }
    public class BlueCar extends car {
        {
            System.out.print("4");
        }
        public BlueCar() {
            super("blue");
            System.out.print("5");
        }
        public static void main(String[] gears) {
            new BlueCar();
        }
    }

