package uvt.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import uvt.services.AlignLeft;
import uvt.services.AlignStrategy;

@Data
@Entity
public class Paragraph extends BaseElement implements Element,Visitee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private String name;

    @Transient
    private AlignStrategy align;
    public Paragraph(String name){
        this.name = name;
        align = new AlignLeft();
    }

    public Paragraph(){}

    @Override
    public void print(){
        if(align == null)
            System.out.println("Paragraph: " + name);
        else
            align.render(name);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(Element e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int i) {
        throw new UnsupportedOperationException();
    }

    public void setAlignStrategy(AlignStrategy align) {
        this.align = align;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }

    public String getText() {
        return name;
    }
}
