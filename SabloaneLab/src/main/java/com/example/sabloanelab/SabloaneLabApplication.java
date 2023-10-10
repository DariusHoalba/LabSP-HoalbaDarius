package com.example.sabloanelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SabloaneLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SabloaneLabApplication.class, args);

    Book discoTitanic = new Book("Disco Titanic");
    Author author = new Author("Radu Pavel Gheo");

    discoTitanic.addAuthor(author);
    int indexChapterOne = discoTitanic.createChapter("Capitolul 1");
    Chapter chp1 = discoTitanic.getChapter(indexChapterOne);
    int indexSubChapterOneOne = chp1.createSubChapter("Subcapitolul 1.1");
    Subchapter scOneOne = chp1.getSubChapter(indexSubChapterOneOne);
    scOneOne.createNewParagraph("Paragraph 1");
    scOneOne.createNewParagraph("Paragraph 2");
    scOneOne.createNewParagraph("Paragraph 3");
    scOneOne.createNewImage("Image 1");
    scOneOne.createNewParagraph("Paragraph 4");
    scOneOne.createNewTable("Table 1");
    scOneOne.createNewParagraph("Paragraph 5");
    scOneOne.print();
    }
}
