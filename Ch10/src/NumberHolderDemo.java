import java.io.FileNotFoundException;

public class NumberHolderDemo
{
    public static void main(String[] args) throws FileNotFoundException {

        //make this work
        NumberHolder holder1 = new NumberHolderAdder("num-list-1.txt");
        NumberHolder holder2 = new NumberHolderGreatest("num-list-2.txt");

        System.out.println("Sum: " + holder1.reduce());
        System.out.println("Greatest: " + holder2.reduce());
    }
}
