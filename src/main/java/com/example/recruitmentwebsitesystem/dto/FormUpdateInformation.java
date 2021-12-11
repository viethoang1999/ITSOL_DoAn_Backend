package com.example.recruitmentwebsitesystem.dto;

public class FormUpdateInformation {

    private String email;

    private String phone;

    private String homeTown;

    private String gender;

    private String birthday;

    private String avatar;

    private String skill;

    private int numberYearsExperience;

    private int desiredSalary;

    private String desiredWorkingAddress;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getNumberYearsExperience() {
        return numberYearsExperience;
    }

    public void setNumberYearsExperience(int numberYearsExperience) {
        this.numberYearsExperience = numberYearsExperience;
    }

    public int getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public String getDesiredWorkingAddress() {
        return desiredWorkingAddress;
    }

    public void setDesiredWorkingAddress(String desiredWorkingAddress) {
        this.desiredWorkingAddress = desiredWorkingAddress;
    }


    public FormUpdateInformation(String email, String phone, String homeTown, String gender, String birthday,
                                 String avatar, String skill, int numberYearsExperience, int desiredSalary, String desiredWorkingAddress) {
        super();
        this.email = email;
        this.phone = phone;
        this.homeTown = homeTown;
        this.gender = gender;
        this.birthday = birthday;
        this.avatar = avatar;
        this.skill = skill;
        this.numberYearsExperience = numberYearsExperience;
        this.desiredSalary = desiredSalary;
        this.desiredWorkingAddress = desiredWorkingAddress;
    }

    public FormUpdateInformation() {
        super();
        // TODO Auto-generated constructor stub
    }
}
