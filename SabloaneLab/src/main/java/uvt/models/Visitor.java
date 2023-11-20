package uvt.models;

public interface Visitor {
    void visitImageProxy(ImageProxy imageProxy);
    void visitImage(Image image);
    void visitTable(Table table);
    void visitSection(Section section);

    void visitSubchapter(Subchapter sub);

    void visitParagraph(Paragraph paragraph);
    void visitBook(Book book);
}
