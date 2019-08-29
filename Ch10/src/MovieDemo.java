import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDemo {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Movie> movies = loadAllMovies();

        for (Movie m : movies)
        {
            System.out.println(m);
        }
    }

    public static ArrayList<Movie> loadAllMovies() throws FileNotFoundException {
        File f = new File("movie_list.txt");
        Scanner inputFile = new Scanner(f);
        ArrayList<Movie> result = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            String name = inputFile.nextLine();
            int year = inputFile.nextInt();
            //skip new line
            inputFile.nextLine();
            String genre = inputFile.nextLine();
            Movie m = new Movie(name, year, genre);
            result.add(m);
        }
        return result;
    }
}
