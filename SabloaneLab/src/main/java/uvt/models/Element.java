package uvt.models;

import jakarta.persistence.*;

public interface Element extends Visitee {
    void print();
    void add(Element e);
    void removeElement(Element e);
    Element get(int i);
}