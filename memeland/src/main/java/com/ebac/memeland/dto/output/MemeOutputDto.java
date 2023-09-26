package com.ebac.memeland.dto.output;

public class MemeOutputDto {
    private Long id;
    private String name;
    private String description;
    private MemeCategoryOutputDto memeCategory;
    private Long userId;

    public MemeOutputDto(Long id, String name, String description, MemeCategoryOutputDto memeCategory, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.memeCategory = memeCategory;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MemeCategoryOutputDto getMemeCategory() {
        return memeCategory;
    }

    public void setMemeCategory(MemeCategoryOutputDto memeCategory) {
        this.memeCategory = memeCategory;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}
