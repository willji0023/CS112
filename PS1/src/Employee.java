public class Employee {
    private String name;
    private int idNumber;
    private String department;
    private String position;

    public Employee(){
        name = "(not set)";
        idNumber = 0;
        department = "(not set)";
        position = "(not set)";
    }

    public Employee(String name, int idNumber){
        this.name = name;
        this.idNumber = idNumber;
        department = "(not set)";
        position = "(not set)";
    }

    public Employee(String name, int idNumber, String department, String position){
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public String getPosition(){
        return position;
    }

    public int getIdNumber(){
        return idNumber;
    }
}
