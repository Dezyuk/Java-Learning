package Exam.BackEndApplicationForOnlineStore.Enteties.impl;

import Exam.BackEndApplicationForOnlineStore.Enteties.User;

public class DefaultUser implements User {
    private static int idIndex = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        id = ++idIndex;
    }

    public DefaultUser() {

    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setPassword(String password) {
        if (password == null) {
            return;
        }
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        if (email == null) {
            return;
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    void clearState() {
        idIndex = 0;
    }
}
