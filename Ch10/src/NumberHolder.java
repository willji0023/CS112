import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class NumberHolder
{
    protected ArrayList<Integer> numbers;

    public NumberHolder()
    {
        numbers = new ArrayList<Integer>();
    }

    public void loadAllNumbersFrom(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner inputFile = new Scanner(f);
        while (inputFile.hasNextInt())
        {
            numbers.add(inputFile.nextInt());
        }
    }

    public abstract int reduce();
}
