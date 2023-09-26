package com.ebac.memeland.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserInputDto {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
