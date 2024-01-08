package uvt.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class  Element implements Visitee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subchapter_id") // Foreign key reference to Subchapter
    private Subchapter subchapter;

    public Element(){}

    abstract void print();
    abstract void add(Element e);
    abstract void removeElement(Element e);

    abstract Element get(int i);
}
