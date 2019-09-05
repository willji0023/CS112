import java.util.ArrayList;

public class MovieReducerLength implements MediaReducer {

    @Override
    public String reduce(ArrayList<Media> list, String key) {
        String output = "";
        for (Media m : list) {
            if (m.getName().length() == Integer.parseInt(key)) {
                output += m.toString() + "\n";
            }
        }
        return output;
    }
}
