public class Movie implements ComplicatedCompare {
    private String name;
    private int year;
    private String genre;

    public Movie(String n, int y, String g) {
        name = n;
        year = y;
        genre = g;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return String.format("%5d %-55s %-15s", year, name, genre);
    }

    @Override
    public boolean hasLongerTitleThan(Movie other) {
        return name.length() > other.name.length();
    }
}
