package Voting.Models;

// The User class will hold the user details that are required for registration.

public class User {

    private int ID;
    private String name;
    private String email;
    private String HashedPassword;

    public User() {
        this.ID = 0;
        this.name = "";
        this.email = "";
        this.HashedPassword = "";
    }

    public User(int ID, String name, String email, String HashedPassword){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.HashedPassword = HashedPassword;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        HashedPassword = hashedPassword;
    }

    public void UserInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Email: " + email);
        System.out.println("Password: " + HashedPassword);
    }
    
}
