package model.user;

public class User {
    private int id;
    private String user;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String sex;
    private String role;
    public User(int id, String user, String password, String fullName, String phoneNumber, String address, String sex , String role) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;
        this.role = role;
    }
 public User(String user, String password, String fullName, String phoneNumber, String address, String sex) {
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;

    }

    public User(int id, String user, String password, String role) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
