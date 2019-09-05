import java.util.ArrayList;

public class MovieReducerEraCount implements MediaReducer {

    @Override
    public String reduce(ArrayList<Media> list, String key) {
        int count = 0;
        for (Media m : list) {
            Movie movie = new Movie(m.getName(), m.getYear(), m.getGenre());
            if (movie.getEra() == key) {
                count++;
            }
        }
        return "Movies in " + key + ": " + Integer.toString(count);
    }
}
