package uvt.models;

import uvt.services.AlignLeft;
import uvt.services.AlignStrategy;

public class Paragraph extends Element{
    private String name;
    private AlignStrategy align;
    public Paragraph(String name){
        this.name = name;
        align = new AlignLeft();
    }

    @Override
    public void print(){
        if(align == null)
            System.out.println("Paragraph: " + name);
        else
            align.render(name);
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
