package com.example.spring_02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {
    @JsonIgnore
    private int id;
    private String name;
    private String author;
    private String description;
    private String img = "/img/";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean matchWithKeywork(String keywork) {
        String keyworkLowerCase = keywork.toLowerCase();
        return (name.toLowerCase().contains(keyworkLowerCase)) ||
                (author.toLowerCase().contains(keyworkLowerCase));
    }
}
