package app.models;

import javax.persistence.*;

@Entity
public class User {
    @SequenceGenerator(name="Account_ids", initialValue=100001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Account_ids")
    @Id
    private int id;
    private String name;
    private String email;
    private String role;
    private String hashedPassword;

    public User() {
    }

    public User(int id, String name, String email, String role, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
