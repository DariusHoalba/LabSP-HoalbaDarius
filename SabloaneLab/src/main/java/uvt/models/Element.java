package uvt.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class  Element implements Visitee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Element(){}

    abstract void print();
    abstract void add(Element e);
    abstract void removeElement(Element e);

    abstract Element get(int i);
}
