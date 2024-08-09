package com.fp.pinappDemo.dto;


import java.util.Date;

public class ClientDTO {

    private int clientId;
    private String firstName;
    private String lastName;
    private int age;
    private Date birthday;
    private Date deathDate;


    public ClientDTO(int clientId, String firstName, String lastName, int age, Date birthday, Date deathDate) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.deathDate = deathDate;
    }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public Date getDeathDate() { return deathDate; }
    public void setDeathDate(Date deathDate) { this.deathDate = deathDate; }


    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", deathDate='" + deathDate + '\'' +
                '}';
    }
}
