package org.example;

import java.sql.SQLOutput;
import java.util.Objects;

public class User {
   private  int id;
   private  String name;
    private String email;
   private  boolean active;

    public User(int id, String name, String email, boolean active) {
        this.id = id;
        setName(name);
        setEmail(email);
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        if (name == null ||name.isBlank() ){
            throw new IllegalArgumentException(
                    "The name can't be null or empty"
            );        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null ||email.isBlank() ){
            throw new IllegalArgumentException(
                    "The email can't be null or empty"
            );        }
        this.email = email;
    }

    public void deactivate(){
        this.active = false;
    }
    public void displayInfo(){
        System.out.println("User id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Active: " + active);
        System.out.println("--------------------------");
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && active == user.active && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, active);
    }
}
