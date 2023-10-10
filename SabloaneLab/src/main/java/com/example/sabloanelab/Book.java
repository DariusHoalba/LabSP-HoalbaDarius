package com.example.sabloanelab;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;

    private List<Chapter> chapters;
    private List<Author> authors;
    public Book(String title, List<Chapter> chapters){
        this.title = title;

        this.chapters = chapters;
    }

    public void addAuthor(Author a){
        authors.add(a);
    }

    public Book(String title){
        title =  title;
        authors = new ArrayList<Author>();
        chapters = null;
    }

    public int createChapter(String ChapterTitle){
        if (chapters == null){
            chapters = new ArrayList<Chapter>();
        }
        Chapter newChapter = new Chapter("ChapterTitle");
        chapters.add(newChapter);
        return chapters.size();
    }

    public void print(){
        System.out.println("Book title: " + title);
    }

    public Chapter getChapter(int index) {
        return chapters.get(index - 1);
    }
}
