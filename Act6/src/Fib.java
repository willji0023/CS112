public class Fib {
    private static long generate(int index, long n1, long n2, int count) {
        if (count == index)
            return n1;
        else
            return generate(index, n2, n2 + n1, count + 1);
    }

    public static long generate(int index) {
        return generate(index, 0, 1, 0);
    }
}
