package uvt.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("section")
@Data
@Entity
public class Section extends BaseElement implements Element{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @OneToMany(targetEntity = BaseElement.class, fetch = FetchType.EAGER)

    private List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public void print(){
        System.out.println(title);
        for(Element e:children)
            e.print();
    }

    @Override
    public void add(Element e){
        children.add(e);
    }

    @Override
    public void removeElement(Element e){
        children.remove(e);
    }

    @Override
    public Element get(int i){
        return children.get(i);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for(Element element :this.children)
            element.accept(visitor);
    }

    public String getName() {
        return title;
    }

    public Iterable<? extends Element> getContent() {
        return children;
    }
}
