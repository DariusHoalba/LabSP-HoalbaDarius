package uvt.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book implements Visitee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(targetEntity = BaseElement.class)
    private List<BaseElement> sections;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Book_Authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    public Book(){}

    public Book(String title, List<BaseElement> sections, List<Author> authors){
        this.title = title;
        this.authors = authors;
        this.sections = sections;
    }

    public void addAuthor(Author a){
        authors.add(a);
    }

    public Book(String title){
        this.title =  title;
        authors = new ArrayList<Author>();
        sections = null;
    }

    public int createSection(String ChapterTitle){
        if (sections == null){
            sections = new ArrayList<BaseElement>();
        }
        Section newSection = new Section("ChapterTitle");
        sections.add(newSection);
        return sections.size();
    }

    public void print(){
        System.out.println("Book: " + title);
        System.out.println("\nAuthors: ");
        for(Author a: authors)
            a.print();
        System.out.println();
        for(Element e:sections)
            e.print();
    }

    public Element getSection(int index) {
        return sections.get(index - 1);
    }

    public void addContent(Element paragraph) {
        if(sections == null) sections = new ArrayList<BaseElement>();
        sections.add((Section) paragraph);
    }

    public String getTitle() {
        return title;
    }

    public List<BaseElement> getSections(){
        return sections;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setSections(List<BaseElement> sections) {
        this.sections = sections;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }

    public void add(Section cap1) {
        if(sections == null) sections = new ArrayList<BaseElement>();
        sections.add(cap1);
    }
}
