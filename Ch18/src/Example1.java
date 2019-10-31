public class Example1 {
    public static void main(String[] args) {
        MyList<Integer> data1 = new MyList<>();
        MyList<Double> data2 = new MyList<>();

        data1.add(5);
        data1.add(10);

        data2.add(5.4);
        data2.add(10.9);
        data2.add(-53.66);
        data2.add(-51.4);
        data2.add(-52.3);

        data2.add(555.2);
        data2.add(998.3);
        data2.add(42.5);
        data2.add(777.2334);
        data2.add(-92.1);

        System.out.println("Greatest in data2: " + data2.getGreatest());
    }
}
