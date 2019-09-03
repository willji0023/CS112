import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MoxieDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Movie> movieList = MovieDemo.loadAllMovies();

        MovieReducer oldestMovie = m -> {
            // m is an ArrayList of Movies BECAUSE of the interface
            Movie result = m.get(0);
            for (Movie current : m) {
                if (current.getYear() < result.getYear()) {
                    result = current;
                }
            }
            return result;
        };
        System.out.println(oldestMovie.reduce(movieList));
    }
}
