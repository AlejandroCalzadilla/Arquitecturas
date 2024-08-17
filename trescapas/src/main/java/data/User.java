package data;

public class User {
    private int id;
    private String name;
    private String lastname;

    public User(int id, String name,String lastname) {
        this.id = id;
        this.name = name;
        this.lastname=lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
