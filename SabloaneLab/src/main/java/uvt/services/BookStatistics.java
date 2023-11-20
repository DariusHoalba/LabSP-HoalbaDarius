package uvt.services;

import uvt.models.*;

public class BookStatistics implements Visitor {
    private int paragraphCount = 0;
    private int imageCount = 0;
    private int tableCount = 0;
    private int sectionCount = 0;
    private int imageProxyCount = 0;
    private int bookCount = 0;
    public void printStatistics() {
        System.out.println("Number of images: " + imageCount);
        System.out.println("Number of tables: " + tableCount);
        System.out.println("Number of paragraphs: " + paragraphCount);
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageCount++;
    }

    @Override
    public void visitImage(Image image) {
        imageCount++;
    }

    @Override
    public void visitTable(Table table) {
        tableCount++;
    }

    @Override
    public void visitSection(Section section) {
        sectionCount++;
    }

    @Override
    public void visitSubchapter(Subchapter sub) {

    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        paragraphCount++;
    }

    @Override
    public void visitBook(Book book) {
        bookCount++;
    }
}
