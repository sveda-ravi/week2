public class Boook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Boook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;  // By default, the book is available
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently unavailable.");
        }
    }

    // Method to return the book (optional)
    public void returnBook() {
        isAvailable = true;
        System.out.println("You have returned: " + title);
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    // Main method to test
    public static void main(String[] args) {
        Boook book1 = new Boook("Java Programming", "Sveda Ravi", 39.99);

        // Show initial details
        book1.displayBookInfo();
        System.out.println();

        // Borrow the book
        book1.borrowBook();
        book1.displayBookInfo();
        System.out.println();

        // Try borrowing again
        book1.borrowBook();
        System.out.println();

        // Return the book
        book1.returnBook();
        book1.displayBookInfo();
    }
}
