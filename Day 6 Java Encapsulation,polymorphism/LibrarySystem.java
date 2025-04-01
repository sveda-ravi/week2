interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower;


    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }


    public String getBorrower() {
        return borrower;
    }


    public boolean isBorrowed() {
        return borrower != null;
    }


    public String getItemDetails() {
        return String.format("ID: %s | Title: %s | Author: %s", itemId, title, author);
    }


    public abstract int getLoanDuration();
}
class Book extends LibraryItem implements Reservable {
    private boolean reserved;


    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }


    public int getLoanDuration() {
        return 14;
    }


    public void reserveItem(String borrowerName) {
        if (!reserved) {
            setBorrower(borrowerName);
            reserved = true;
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book already reserved.");
        }
    }


    public boolean checkAvailability() {
        return !reserved;
    }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean reserved;


    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }


    public int getLoanDuration() {
        return 7;
    }


    public void reserveItem(String borrowerName) {
        if (!reserved) {
            setBorrower(borrowerName);
            reserved = true;
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine already reserved.");
        }
    }


    public boolean checkAvailability() {
        return !reserved;
    }
}
class DVD extends LibraryItem implements Reservable {
    private boolean reserved;


    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }


    public int getLoanDuration() {
        return 3;
    }


    public void reserveItem(String borrowerName) {
        if (!reserved) {
            setBorrower(borrowerName);
            reserved = true;
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD already reserved.");
        }
    }


    public boolean checkAvailability() {
        return !reserved;
    }
}
public class LibrarySystem {
    public static void processLibraryItems(LibraryItem[] items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");


            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;


                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem("User123");
                } else {
                    System.out.println("Item is currently not available for reservation.");
                }
            }


            System.out.println("----------------------------");
        }
    }


    public static void main(String[] args) {
        LibraryItem[] collection = {
                new Book("B101", "Java Fundamentals", "James Gosling"),
                new Magazine("M202", "Tech Weekly", "Editor Group"),
                new DVD("D303", "Inception", "Christopher Nolan")
        };


        processLibraryItems(collection);
    }
}
