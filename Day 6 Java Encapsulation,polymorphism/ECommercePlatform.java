interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
abstract class Product {
    private int productId;
    private String name;
    private double price;


    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double calculateDiscount();


    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }


    public double calculateDiscount() {
        return getPrice() * 0.10;
    }


    public double calculateTax() {
        return getPrice() * 0.18;
    }


    public String getTaxDetails() {
        return "18% GST on electronics";
    }
}
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }


    public double calculateDiscount() {
        return getPrice() * 0.15;
    }


    public double calculateTax() {
        return getPrice() * 0.12;
    }


    public String getTaxDetails() {
        return "12% GST on clothing";
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }


    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}


public class ECommercePlatform {
    public static void printFinalPrices(Product[] products) {
        for (Product p : products) {
            p.displayProduct();


            double discount = p.calculateDiscount();
            double tax = 0;


            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println("Tax Details: " + t.getTaxDetails());
            }


            double finalPrice = p.getPrice() + tax - discount;
            System.out.printf("Discount: $%.2f\n", discount);
            System.out.printf("Tax: $%.2f\n", tax);
            System.out.printf("Final Price: $%.2f\n", finalPrice);
            System.out.println("-----------------------------");
        }
    }


    public static void main(String[] args) {
        Product[] productList = {
                new Electronics(1, "Smartphone", 1000),
                new Clothing(2, "Jacket", 200),
                new Groceries(3, "Rice Bag", 50)
        };


        printFinalPrices(productList);
    }
}
