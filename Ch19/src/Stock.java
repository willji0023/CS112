import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Stock {
  String ticker, name, industry, price;

  public static void load(Map<String, Stock> data) {
    try {
      Scanner inputFile = new Scanner(new File("stocks.txt"));
      inputFile.nextLine();
      while (inputFile.hasNext()) {
        Stock s = new Stock(inputFile.nextLine().split("\t"));
        data.put(s.ticker, s);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void load(Set<Stock> data) {
    try {
      Scanner inputFile = new Scanner(new File("stocks.txt"));
      inputFile.nextLine();
      while (inputFile.hasNext()) {
        Stock s = new Stock(inputFile.nextLine().split("\t"));
        data.add(s);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Stock(String[] tokens) {
    this.ticker = tokens[0];
    this.name = tokens[1];
    this.industry = tokens[2];
    this.price = tokens[3];
  }

  public String toString() {
    return ticker + " " + name + " " + industry + " " + price;
  }
}