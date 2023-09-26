package com.ebac.memeland.memes.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "memes")
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "usuario_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "meme_category_id")
    private Category memeCategory;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Meme() {
    }

    public Meme(String name, String description, Long userId, Category memeCategory) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.memeCategory = memeCategory;
    }

    public Long getId() {
        return id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Category getMemeCategory() {
        return memeCategory;
    }

    public void setMemeCategory(Category memeCategory) {
        this.memeCategory = memeCategory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
