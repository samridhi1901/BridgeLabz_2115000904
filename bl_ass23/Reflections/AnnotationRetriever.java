import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply the annotation to a class
@Author(name = "John Doe")
class Book {
    void display() {
        System.out.println("Book class method executed.");
    }
}

public class AnnotationRetriever {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;

        // Retrieve and display the annotation value
        if (bookClass.isAnnotationPresent(Author.class)) {
            Author author = bookClass.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
