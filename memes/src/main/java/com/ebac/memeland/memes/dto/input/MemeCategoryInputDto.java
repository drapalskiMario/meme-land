package com.ebac.memeland.memes.dto.input;

import jakarta.validation.constraints.NotBlank;

public class MemeCategoryInputDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public MemeCategoryInputDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
