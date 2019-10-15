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

    long startTime = System.currentTimeMillis();
    // Example1.bubbleSort(data);
    Example2.selectionSort(data);
    // Example3.insertionSort(data);
    long endTime = System.currentTimeMillis();
    long runTime = endTime - startTime;

    for (String word : data)
    {
      System.out.println(word);
    }
    System.out.println("Swaps: " + Example2.numSwaps);
    System.out.println("Iterations: " + Example2.numIterations);
    System.out.println("Run time: " + runTime);
  }
}
