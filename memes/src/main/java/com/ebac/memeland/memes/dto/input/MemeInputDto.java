package com.ebac.memeland.memes.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MemeInputDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    @Positive
    private Long memeCategoryId;
    @NotNull
    @Positive
    private Long userId;

    public MemeInputDto(String name, String description, Long memeCategoryId, Long userId) {
        this.name = name;
        this.description = description;
        this.memeCategoryId = memeCategoryId;
        this.userId = userId;
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

    public Long getMemeCategoryId() {
        return memeCategoryId;
    }

    public void setMemeCategoryId(Long memeCategoryId) {
        this.memeCategoryId = memeCategoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
