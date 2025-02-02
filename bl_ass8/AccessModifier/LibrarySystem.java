class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookInfo() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN);  
        System.out.println("Title: " + title); 
        System.out.println("File Size: " + fileSize + " MB");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        book1.displayBookInfo();
        System.out.println();

        book1.setAuthor("Updated Author");
        System.out.println("Updated Author: " + book1.getAuthor());
        System.out.println();

        EBook ebook1 = new EBook("978-1491950357", "Clean Code", "Robert C. Martin", 2.5);
        ebook1.displayEBookInfo();
    }
}