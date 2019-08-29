public class JobDemo {
    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = new Employee();
        Person p3 = new Manager();
        Person p4 = new NightManager();

        System.out.println(p4);
        System.out.println(p3);
        System.out.println(p2);
        System.out.println(p1);
    }
}
