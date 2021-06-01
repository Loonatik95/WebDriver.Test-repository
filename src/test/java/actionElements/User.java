package actionElements;

public class User {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String postcode;
    private final String city;
    private final String email;
    private final String phone;
    private final String password;
    private final String confirmedPassword;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        phone = "+4567895656";
        address = "RB";
        postcode = "12345";
        city = "Gomel";
        confirmedPassword = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }
}
