package uvt.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@JsonTypeName("image")
@Entity
@Data
public class Image extends BaseElement implements Element {
    private String imagename;

    public Image(String imagename){
        this.imagename = imagename;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Image() {

    }

    @Override
    public void print(){
        System.out.println("Image with name: " + imagename);
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
        return imagename;
    }

    public void setImageName(String imagename) {
        this.imagename = imagename;
    }
}