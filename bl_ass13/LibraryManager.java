class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head;
    private Book tail;
    private int count;

    public Library() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void addBookAtPosition(int bookId, String title, String author, String genre, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(bookId, title, author, genre, isAvailable);
            return;
        }
        if (position >= count) {
            addBookAtEnd(bookId, title, author, genre, isAvailable);
            return;
        }
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        Book temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    public void removeBookById(int bookId) {
        if (head == null) return;

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            count--;
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;

        count--;
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author +
                        " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found: " + title);
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author +
                        " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    public void updateAvailability(int bookId, boolean availability) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = availability;
                System.out.println("Availability updated for book: " + temp.title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + bookId);
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author +
                    " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author +
                    " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }

    public int countTotalBooks() {
        return count;
    }
}

public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", true);
        library.addBookAtEnd(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        library.addBookAtBeginning(3, "1984", "George Orwell", "Dystopian", false);
        library.addBookAtPosition(4, "Moby Dick", "Herman Melville", "Adventure", true, 2);

        System.out.println("Books in Forward Order:");
        library.displayBooksForward();

        System.out.println("\nBooks in Reverse Order:");
        library.displayBooksReverse();

        System.out.println("\nTotal Books in Library: " + library.countTotalBooks());

        System.out.println("\nSearch by Title: 1984");
        library.searchByTitle("1984");

        System.out.println("\nSearch by Author: Harper Lee");
        library.searchByAuthor("Harper Lee");

        System.out.println("\nUpdating availability of Book ID 1 to false");
        library.updateAvailability(1, false);

        System.out.println("\nLibrary after update:");
        library.displayBooksForward();

        System.out.println("\nRemoving Book ID 3");
        library.removeBookById(3);

        System.out.println("\nLibrary after removal:");
        library.displayBooksForward();

        System.out.println("\nTotal Books in Library: " + library.countTotalBooks());
    }
}
