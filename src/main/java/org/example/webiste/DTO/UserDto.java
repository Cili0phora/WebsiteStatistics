package org.example.webiste.DTO;

import javax.validation.constraints.*;

public class UserDto {

    public UserDto(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public UserDto(long id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public UserDto() {
    }

    private long id;

    @NotEmpty(message = "User's name cannot be empty")
    private String name;

    @Min(value = 2, message = "Invalid birth year")
    private int birthYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
