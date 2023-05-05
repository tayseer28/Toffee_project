package user;

public abstract class UserAccount {

    private String userName;
    private String password;
    private String status;

    private String email;

    public UserAccount(String userName, String password, String status, String email) {
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
