// Parent class: LibraryBook
class LibraryBook {
    public String ISBN;        // public variable
    protected String title;    // protected variable
    private String author;     // private variable

    // Constructor
    public LibraryBook(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends LibraryBook {
    private double fileSizeMB;

    // Constructor for EBook
    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);  // call parent constructor
        this.fileSizeMB = fileSizeMB;
    }

    // Method to display EBook details
    public void displayEBookDetails() {
        System.out.println("E-Book ISBN (public): " + ISBN);         // accessing public member
        System.out.println("E-Book Title (protected): " + title);    // accessing protected member
        // Can't access author directly here because it's private in the parent class
        System.out.println("File Size: " + fileSizeMB + " MB");
    }
}

// Main class to test
public class BookManagementSystem {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("978-1234567890", "Java Basics", "John Doe");
        book.displayBookDetails();

        System.out.println();

        EBook ebook = new EBook("978-0987654321", "Advanced Java", "Alice Smith", 5.2);
        ebook.displayEBookDetails();

        // Using public getter to access private author field
        System.out.println("E-Book Author (via getter): " + ebook.getAuthor());
    }
}
