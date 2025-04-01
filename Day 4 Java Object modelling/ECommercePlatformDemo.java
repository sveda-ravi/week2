import java.util.*;

// Product class
class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }
}

// Order class (aggregates Products)
class Order {
    private String orderId;
    private List<Product> products;
    private Customer customer;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("\nOrder ID: " + orderId + " placed by " + customer.getName());
        double total = 0;
        for (Product p : products) {
            System.out.println("  - " + p.getName() + " ($" + p.getPrice() + ")");
            total += p.getPrice();
        }
        System.out.println("Total Amount: $" + total);
    }

    public String getOrderId() {
        return orderId;
    }
}

// Customer class (places Orders)
class Customer {
    private String customerId;
    private String name;
    private List<Order> orders;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed a new order: " + order.getOrderId());
    }

    public void showOrderHistory() {
        System.out.println("\nOrder History for " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

// Main class
public class ECommercePlatformDemo {
    public static void main(String[] args) {
        // Create Products
        Product p1 = new Product("P101", "Laptop", 750.00);
        Product p2 = new Product("P102", "Smartphone", 500.00);
        Product p3 = new Product("P103", "Headphones", 80.00);

        // Create Customer
        Customer customer1 = new Customer("C001", "Riya");

        // Create Order
        Order order1 = new Order("O001", customer1);
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order("O002", customer1);
        order2.addProduct(p2);

        // Customer places orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // Show order history
        customer1.showOrderHistory();
    }
}
