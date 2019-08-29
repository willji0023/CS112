import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDemo {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Movie> movies = loadAllMovies();

        // assume first movie has the longest title
        Movie movieWithLongestName = movies.get(0);
        Movie movieReleasedEarliest = movies.get(0);
        for (Movie m : movies)
        {
            if (m.hasLongerNameThan(movieWithLongestName)){
                movieWithLongestName = m;
            }
            if (m.wasReleasedBefore(movieReleasedEarliest)){
                movieReleasedEarliest = m;
            }
        }
        System.out.println(movieWithLongestName);
        System.out.println(movieReleasedEarliest);
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
