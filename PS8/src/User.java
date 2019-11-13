public class User implements Comparable<User> {
    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%20s%20s", password, username);
    }

    @Override
    public int compareTo(User user) {
        if (password.length() > user.password.length())
            return 1;
        else if (password.length() < user.password.length())
            return -1;
        else {
            if (!password.equalsIgnoreCase(user.password))
                return password.compareToIgnoreCase(user.password);
            else
                return username.compareToIgnoreCase(user.username);
        }
    }
}
