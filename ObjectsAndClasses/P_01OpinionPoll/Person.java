package ObjectsAndClasses.P_01OpinionPoll;

public class Person {

    public String name;
    public static int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        if (isEligible()) {
            return age;
        }
        return 0;
    }

    public static boolean isEligible (){
        return age > 30;
    }
}
