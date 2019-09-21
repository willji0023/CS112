import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;

    public Contact(String n, String p, String e){
        name = n;
        phone = p;
        email = e;
    }

    public String toString() {
        return name + "\n" + phone + "\n" + email + "\n";
    }
}
