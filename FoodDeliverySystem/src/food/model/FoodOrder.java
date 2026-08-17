package food.model;

public abstract class FoodOrder {

    private int orderId;
    private String customerName;
    private double amount;

    private static String restaurantName = "Food Express";

    private static int orderCounter = 0;

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void setRestaurantName(String restaurantName) {
        FoodOrder.restaurantName = restaurantName;
    }

    // Static method
    public static void displayTotalOrders() {
        System.out.println("Total Orders: " + orderCounter);
    }

    // Abstract method
    public abstract double calculateDeliveryCharge();
}
