package com.example.crash.parcial;

public class Contact {

    private String name;
    private int image;
    private String lastName;
    private int phone;
    private int id;
    private String email;
    private String address;
    private String birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Contact() {
    }

    public Contact(String name, int image, String lastName, int phone, int id, String email, String address, String birthDate) {
        this.name = name;
        this.image = image;
        this.lastName = lastName;
        this.phone = phone;
        this.id = id;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

}
