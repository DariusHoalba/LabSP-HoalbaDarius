package com.example.sabloanelab;

public class Paragraph implements Element{
    private String name;
    public Paragraph(String name){
        this.name = name;
    }

    @Override
    public void print(){
        System.out.println("Paragraph: " + name);
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
}
