package starter.enums;

public enum Users {
    JOHN("john@gmail.com", "superSecret");

    private String email;
    private String password;

    Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
