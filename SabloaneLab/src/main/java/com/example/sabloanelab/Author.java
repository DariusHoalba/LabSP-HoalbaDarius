package com.example.sabloanelab;

public class Author {
    String name;

    public Author(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Author name: " + name);
    }
}
