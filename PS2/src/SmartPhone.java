public class SmartPhone extends Phone {

    protected String email;

    public SmartPhone(){
        email = "None";
    }

    public SmartPhone(String name, String number){
        super(name, Long.parseLong(number));
        email = "None";
    }

    public SmartPhone(String name, String number, String email){
        super(name, Long.parseLong(number));
        this.email = email;
    }

    public String toString(){
        String output = "Name: " + name + "\n";
        if (number == -1){
            output += "Phone: Not set\n";
        } else {
            output += "Phone: " + number + "\n";
        }
        output += "Email: " + email + "\n";
        output += "Telephone neighbor: " + getTeleponeNeighbor() + "\n";
        return output;
    }

    public boolean hasPhoneNumber(){
        return number != -1;
    }

    public String getAreaCode(){
        return Long.toString(number).substring(0, 3);
    }

    public String getPrefix(){
        return Long.toString(number).substring(3, 6);
    }

    public String getLineNumber(){
        return Long.toString(number).substring(6, 10);
    }

    public String getTeleponeNeighbor(){
        if (number != -1){
            long numberNeighbor = number + 1;
            return "(" + Long.toString(numberNeighbor).substring(0, 3) + ") " + Long.toString(numberNeighbor).substring(3, 6) + "-" + Long.toString(numberNeighbor).substring(6, 10);
        } else {
            return "Cannot calculate phone number neighbor";
        }
    }
}
