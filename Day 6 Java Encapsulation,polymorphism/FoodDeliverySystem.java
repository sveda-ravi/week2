interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;


    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return itemName;
    }


    public double getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }


    protected void setPrice(double newPrice) {
        this.price = newPrice;
    }


    protected void setQuantity(int newQty) {
        this.quantity = newQty;
    }
    public String getItemDetails() {
        return String.format("Item: %s | Price: %.2f | Qty: %d", itemName, price, quantity);
    }
    public abstract double calculateTotalPrice();
}
class VegItem extends FoodItem implements Discountable {
    private double discount = 0;


    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }


    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }


    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
        System.out.println(getItemName() + " discount applied: " + percentage + "%");
    }


    @Override
    public String getDiscountDetails() {
        return getItemName() + " has a discount of " + discount + "%.";
    }
}
class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private final double nonVegCharge = 20.0; // Extra fee per item


    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }


    @Override
    public double calculateTotalPrice() {
        double base = (getPrice() + nonVegCharge) * getQuantity();
        return base - (base * discount / 100);
    }


    @Override
    public void applyDiscount(double percentage) {
        this.discount = percentage;
        System.out.println(getItemName() + " discount applied: " + percentage + "%");
    }


    @Override
    public String getDiscountDetails() {
        return getItemName() + " has a discount of " + discount + "% and includes a non-veg charge.";
    }
}
public class FoodDeliverySystem {
    public static void processOrder(FoodItem[] order) {
        double grandTotal = 0;


        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            double totalPrice = item.calculateTotalPrice();
            System.out.printf("Total Price: ₹%.2f\n", totalPrice);


            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
            }


            grandTotal += totalPrice;
            System.out.println("-----------------------------");
        }


        System.out.printf("Grand Total: ₹%.2f\n", grandTotal);
    }


    public static void main(String[] args) {
        FoodItem[] order = {
                new VegItem("Paneer Tikka", 150.0, 2),
                new NonVegItem("Chicken Biryani", 200.0, 1),
                new NonVegItem("Fish Fry", 180.0, 2)
        };


        ((Discountable) order[0]).applyDiscount(10);
        ((Discountable) order[1]).applyDiscount(5);
        ((Discountable) order[2]).applyDiscount(0);


        processOrder(order);
    }
}
