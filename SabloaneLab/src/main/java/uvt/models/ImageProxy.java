package uvt.models;

import jakarta.persistence.*;

import java.awt.*;

//@Entity
public class ImageProxy extends Element implements Picture {

    String url;
    Dimension dim;

    Image realImage;

    public ImageProxy(){}

    ImageProxy(String url, Dimension dim, uvt.models.Image realImage)
    {
        this.url = url;
        this.dim = dim;
        this.realImage = realImage;
    }

    public ImageProxy(String url){
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

    public Image loadImage(){
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
