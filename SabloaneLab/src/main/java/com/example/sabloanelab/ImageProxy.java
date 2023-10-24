package com.example.sabloanelab;

import java.awt.*;

public class ImageProxy implements Picture, Element{

    String url;
    Dimension dim;

    Image realImage;

    ImageProxy(String url, Dimension dim, Image realImage)
    {
        this.url = url;
        this.dim = dim;
        this.realImage = realImage;
    }

    ImageProxy(String url){
        this.url = url;
        dim = null;
        realImage = null;
    }
    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dim;
    }

    @Override
    public String content() {
        return null;
    }

    private Image loadImage(){
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override
    public void add(Element e) {

    }

    @Override
    public void removeElement(Element e) {

    }

    @Override
    public Element get(int i) {
        return null;
    }
}
