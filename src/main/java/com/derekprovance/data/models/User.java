package com.derekprovance.data.models;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Long pocketChange;
    private Long witholdings;
    private Long deductions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPocketChange() {
        return pocketChange;
    }

    public void setPocketChange(Long pocketChange) {
        this.pocketChange = pocketChange;
    }

    public Long getWitholdings() {
        return witholdings;
    }

    public void setWitholdings(Long witholdings) {
        this.witholdings = witholdings;
    }

    public Long getDeductions() {
        return deductions;
    }

    public void setDeductions(Long deductions) {
        this.deductions = deductions;
    }
}
