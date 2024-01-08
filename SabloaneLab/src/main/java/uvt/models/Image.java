package uvt.models;

import java.util.concurrent.TimeUnit;

public class Image extends Element{
    private String url;
    private String name;

    Image(String url, String name){
        this.url = url;
        this.name = name;
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Image(String url){
        this.url = url;
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
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
}
