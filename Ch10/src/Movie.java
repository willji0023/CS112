public class Movie implements ComplicatedCompare, MovieNameCheck {
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
    public boolean hasLongerNameThan(Movie other) {
        return name.length() > other.getName().length();
    }

    @Override
    public boolean wasReleasedBefore(Movie m) {
        return year < m.getYear();
    }
}
