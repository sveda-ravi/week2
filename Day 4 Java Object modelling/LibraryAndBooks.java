import java.util.ArrayList;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}


class Library {
    private String libraryName;
    private ArrayList<Book> books;
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }


    public void displayBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            System.out.println(book);
        }
    }


    public String getLibraryName() {
        return libraryName;
    }
}
public class LibraryAndBooks {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("Moby Dick", "Herman Melville");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee");




        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");




        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book4);




        library1.displayBooks();
        library2.displayBooks();
    }
}
