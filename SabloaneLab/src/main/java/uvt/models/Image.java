package uvt.models;

import jakarta.persistence.*;

import java.util.concurrent.TimeUnit;

@Entity
public class Image extends Element{

    @Column(name = "url")
    private String url;
    private String name;

    public Image(){}

    Image(String url, String name){
        this.url = url;
        this.name = name;
        //TimeUnit.SECONDS.sleep(5);
    }

    public Image(String url){
        this.url = url;
        //TimeUnit.SECONDS.sleep(5);
    }

    @Override
    public void print(){
        System.out.println("Image with URL: " + url) ;
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

    public String getImageName() {
        return name;
    }

    public void setImageName(String name) {
        this.name = name;
    }
}
