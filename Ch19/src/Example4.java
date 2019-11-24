import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Example4 {
    public static void main(String[] args) {
        try {
            Stream<String> data = Files.lines(Path.of("buzzwords.txt"));
            data.filter(x -> x.length() > 10)
                    .sorted()
                    // .peek(x -> System.out.println(x))
                    .limit(100)
                    .forEach(x -> System.out.println(x));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
