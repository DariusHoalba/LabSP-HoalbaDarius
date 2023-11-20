package uvt.services;

import uvt.models.*;

public class TableOfContentUpdate implements Visitor {
    private TableOfContent toc;
    private int currentPage = 1;

    public TableOfContentUpdate(TableOfContent toc) {
        this.toc = toc;
    }

    @Override
    public void visitBook(Book book) {
        // Book might not be directly in the table of contents
        // but you can start the page number from 1 here
    }

    @Override
    public void visitSection(Section section) {
        toc.addEntry(section.getName(), currentPage);
        // Assuming each section starts on a new page
        currentPage++;
    }

    @Override
    public void visitSubchapter(Subchapter sub){
        toc.addEntry(sub.getTitle(), currentPage);
        currentPage++;
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        currentPage++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        currentPage++;
    }

    @Override
    public void visitImage(Image image) {
        currentPage++;
    }

    @Override
    public void visitTable(Table table) {
        currentPage++;
    }
}
