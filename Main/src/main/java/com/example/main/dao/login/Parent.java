package com.example.main.dao.login;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String name;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;
    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Lob
    @Column(name = "expert_picture")
    private byte[] expertPicture;

    @Column(name = "is_expert", nullable = false)
    private boolean isExpert = false;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private List<Baby> babies;

    public Parent(){}

    public Parent(Long id, String name, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public void setBabies(List<Baby> babies) {
        this.babies = babies;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getExpertPicture() {
        return expertPicture;
    }

    public void setExpertPicture(byte[] expertPicture) {
        this.expertPicture = expertPicture;
    }

    public boolean isExpert() {
        return isExpert;
    }

    public void setExpert(boolean expert) {
        isExpert = expert;
    }
}

