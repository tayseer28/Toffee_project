import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public  class UserAccount {

    private Cart cart;
    private Order order;
    private Address address;
    private String userName;
    private String password;

    private String email;
    private String phoneNum;
    private int id;
    private static int StatID;


    static {
        StatID = 1;
    }
    public UserAccount() {
        userName = "";
        password = "";
        email = "";
        phoneNum = "";
        address = new Address();
        id = StatID;
        StatID++;
    }

    public UserAccount(String userName, String password,String email ,String phoneNum, Address address) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        id = StatID;
        StatID++;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
