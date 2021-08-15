package org.example.webiste.DTO;

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

    private String name;

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
}
