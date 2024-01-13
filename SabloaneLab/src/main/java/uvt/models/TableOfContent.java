package uvt.models;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TableOfContent extends BaseElement implements Element{

    private Map<String, Integer> entries = new LinkedHashMap<>();
    public void print(){
        System.out.println("Sample");
    }
    @Override
    public void add(Element e){
        throw new UnsupportedOperationException();
    }

    public void addEntry(String title, Integer pageNumber) {
        entries.put(title, pageNumber);
    }

    @Override
    public void removeElement(Element e){
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int i){
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TableOfContent\n");
        for (Map.Entry<String, Integer> entry : entries.entrySet()) {
            sb.append(entry.getKey()).append(" ................................ ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
