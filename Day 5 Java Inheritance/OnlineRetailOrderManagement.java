class Order {
    protected String orderId;
    protected String orderDate;


    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }


    public String getOrderStatus() {
        return "Order placed";
    }
}


class ShippedOrder extends Order {
    protected String trackingNumber;


    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }


    @Override
    public String getOrderStatus() {
        return "Order shipped - Tracking Number: " + trackingNumber;
    }
}


class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;


    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }


    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}


public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD001", "2025-04-10");
        ShippedOrder shipped = new ShippedOrder("ORD002", "2025-04-09", "TRK12345");
        DeliveredOrder delivered = new DeliveredOrder("ORD003", "2025-04-08", "TRK67890", "2025-04-12");


        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}
