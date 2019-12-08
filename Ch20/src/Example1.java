public class Example1 {
    public static void main(String[] args) {
        // this is our custom linked list, not java's
        MyLinkedList<String> t = new MyLinkedList<>();

        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        t.add("E");
        t.add("F");
        t.add(0, "X");
        t.add(3, "Y");
        t.add(t.size(), "Z");

        System.out.println("Testing print in reverse");
        t.printInReverse();
        System.out.println("End testing");

        t.remove(0);
        t.remove(2);
        t.remove(6);

//        if (t.isEmpty())
//            System.out.println("List is empty!");
//        else
//            System.out.println("List size is " + t.size());
//
//        System.out.println(t.get(0));
//        System.out.println(t.get(1));
//        System.out.println(t.get(2));
//
//        // SUPER SLOW: O(N^2)
//        for (int subscript = 0; subscript < t.size(); subscript++)
//            System.out.println(t.get(subscript));

        // PRETTY GOOD: O(N)
        System.out.println(t);
    }
}
