import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class StackUtils {
    public static Stack<Character> buildStack(File f) {
        Stack<Character> curlyBraces = new Stack<>();
        try {
            Scanner inputFile = new Scanner(f);
            while(inputFile.hasNext()) {
                String[] tokens = inputFile.nextLine().split("[ ]+");
                for (String token : tokens){
                    if (token.equals("{") || token.equals("}"))
                        curlyBraces.add(token.charAt(0));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return curlyBraces;
    }

    public static int reduce(File f) {
        Stack<Character> curlyBraces = buildStack(f);
        int opening = 1, closing = 1; // Equal to 1 so division by 0 never occurs
        while (!curlyBraces.empty()) {
            char brace = curlyBraces.pop();
            if (brace == '}')
                closing++;
            else if (brace == '{') {
                if (closing > opening)
                    opening++;
                else
                    return -1; // Too many brackets opening the wrong way
            }
        }
        return closing % opening;
    }
}
