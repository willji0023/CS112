import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class  WordList
{
  public static ArrayList<String> load()
  {
    ArrayList<String> words = new ArrayList<String>();
    try {
      Scanner inputFile = new Scanner(new File("words.txt"));
      while (inputFile.hasNextLine())
      {
        words.add(inputFile.nextLine());
      }
      inputFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return words;
  }

  public static void main(String[] args)
  {
    ArrayList<String> data = load();

    Example1.bubbleSort(data);

    for (String word : data)
    {
      System.out.println(word);
    }
    System.out.println("Swaps: " + Example1.numSwaps);
    System.out.println("Iterations: " + Example1.numIterations);
  }
}
