package com.codebay.goldeneye;

public class Employee {
    private String name;
    private String surname;
    private String location;
    private String department;
    private String email;

    public Employee() {
    }

    public Employee(String name, String surname, String location, String department) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.department = department;
        //setEmail(name, surname, location, department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name, String surname, String location, String department) {
        this.email = name.charAt(0) + surname + "." + department + "@" + location + ".goldeneye.com";
    }
}
