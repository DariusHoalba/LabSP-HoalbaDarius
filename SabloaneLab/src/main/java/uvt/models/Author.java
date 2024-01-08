package uvt.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
        this.name = "";
    }

    public void print(){
        System.out.println("Author: " + name);
    }
}
