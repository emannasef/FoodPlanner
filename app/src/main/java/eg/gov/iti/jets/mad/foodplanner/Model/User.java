package eg.gov.iti.jets.mad.foodplanner.Model;

public class User {
    String Name,Email;

    public User(String name, String email) {
        Name = name;
        Email = email;
    }

    public User(){

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
