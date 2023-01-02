public class StaticKey {
//    here we can see that our main function is also static because we only want main function
//    once for our public class
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.school = "Prerna Kiran Public School";
//        here we set the school name for s1 for cause of static keyword it become same for
//        for every object
        Student s2 = new Student();
        System.out.println(s2.school);
        System.out.println(s2.returnPercentage(90,77,86));
        Student s3 = new Student();
        s3.school = "LVS";
        System.out.println(s3.returnPercentage(99,90,80));
//        here we can see from where we change the static variable it become same for every object
//        either it is previous one or upcoming
        System.out.println(s2.school);
    }
}
class Student{
    String name;
    int roll;
    static String school;

    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
//    static function for finding percentage of student
//    because the method of finding percentage is not gonna change therefore
//    we make it static
    static int returnPercentage(int math, int chem, int physics){
        return (math+chem+physics)/3;
    }
}
