package com.ruffy.powerUser.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="power_user")
public class PowerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message="First Name cannot be null")
    @NotBlank
    @Length(min = 3)
    @Column(name="first_name")
    private String firstName;


    @NotNull(message="Last Name cannot be null")
    @NotBlank
    @Length(min = 3, message = "Last Name can not be less than 3 characters")
    @Column(name="last_name")
    private String lastName;
    @Column(name="address")
    @NotBlank
    @NotNull
    private String address;


    @Pattern(regexp = "[0-9]{11}")
    @Column(name="phone_number")
    private String phoneNumber;


    @Email
    @NotBlank
    @Column(name="email_address")
    private String emailAddress;

    @Length(min = 5, message = "Password length can not be less than 5 characters")
    @NotBlank
    @Column(name="password")
    private String passWord;

    public PowerUser() {}

    public PowerUser(String firstName, String lastName, String address, String phoneNumber, String emailAddress, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passWord = passWord;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
