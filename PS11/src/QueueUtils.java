import java.util.LinkedList;
import java.util.Queue;

public class QueueUtils {
    public static Queue<String> build(String line) {
        Queue<String> queue = new LinkedList<>();
        String[] tokens = line.split("[ ]+");
        for (String token : tokens)
                queue.add(token);
        return queue;
    }

    // I GOT THIS FIRST TRY LETS GOOOOOOO. IM A RECURSIVE GOD
    public static int eval(Queue<String> s) {
        String token = s.remove();
        if (token.equals("+"))
            return eval(s) + eval(s);
        else if (token.equals("-"))
            return eval(s) - eval(s);
        else if (token.equals("*"))
            return eval(s) * eval(s);
        else if (token.equals("/"))
            return eval(s) / eval(s);
        else
            return Integer.parseInt(token);
    }
}
