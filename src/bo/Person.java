package bo;

public class Person {

    private String name;
    private String password;
    private int id;

    public Person(){}

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
