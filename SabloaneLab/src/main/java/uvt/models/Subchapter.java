package uvt.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Subchapter {
    private String name;

    private List<Element> elements;

    Subchapter(String name, List<Element> elements){
        this.name=name;
        this.elements = elements;
    }

    public Subchapter(){}

    Subchapter(String name){
        this.name = name;
        elements = null;
    }

    public void createNewParagraph(String text) {
        if(elements == null)
            elements = new ArrayList<Element>();
        this.elements.add(new Paragraph(text));
    }

    public void createNewImage(String imageName) {
        if(elements == null)
            elements = new ArrayList<Element>();
        this.elements.add(new Image(imageName));
    }

    public void createNewTable(String tableName) {
        if(elements == null)
            elements = new ArrayList<Element>();
        this.elements.add(new Table(tableName));
    }

    public void print(){
        System.out.println("Subchapter name: " + name + "\n");
        for(Element e: elements){
            e.print();
            System.out.println('\n');
        }
    }

    public String getTitle() {
        return name;
    }
}
