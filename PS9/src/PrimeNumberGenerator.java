import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class PrimeNumberGenerator {
    private static boolean isPrime(long number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Long> generate(int howMany) {
        List<Long> data = new LinkedList<>();
        long number = 2;
        while (data.size() < howMany) {
            if (isPrime(number))
                data.add(number);
            number++;
        }
        return data;
    }
}
