import java.util.ArrayList;

public class MovieReducerExtremes implements MediaReducer {
    @Override
    public String reduce(ArrayList<Media> list, String key) {
        if (key == "Newest") {
            Movie newest = new Movie("", 0, "");
            for (Media m : list) {
                Movie current = new Movie(m.getName(), m.getYear(), m.getGenre());
                if (current.wasReleasedAfter(newest)) {
                    newest = current;
                }
            }
            return newest.toString();
        } else if (key == "Oldest") {
            Movie oldest = new Movie("", 10000, "");
            for (Media m : list) {
                Movie current = new Movie(m.getName(), m.getYear(), m.getGenre());
                if (current.wasReleasedBeforeOrInSameYear(oldest)) {
                    oldest = current;
                }
            }
            return oldest.toString();
        } else {
            return "Invalid key";
        }
    }
}
