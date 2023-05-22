package ru.danilov.raceapi.dto;

import javax.validation.constraints.NotEmpty;

/**
 * User: Nikolai Danilov
 * Date: 22.05.2023
 */
public class PersonDTO {
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
