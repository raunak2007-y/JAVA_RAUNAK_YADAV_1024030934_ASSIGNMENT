package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;

public class Main {

    public static void main(String[] args) {

        FoodOrder.setRestaurantName("Food Express");

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Aman", 500);
        orders[1] = new PremiumOrder(102, "Simran", 1000);
        orders[2] = new RegularOrder(103, "Rahul", 750);
        orders[3] = new PremiumOrder(104, "Neha", 1500);
        orders[4] = new RegularOrder(105, "Karan", 800);
        orders[5] = new PremiumOrder(106, "Priya", 1200);

        System.out.println("======================================");
        System.out.println("          " + FoodOrder.getRestaurantName());
        System.out.println("             FOOD ORDERS");
        System.out.println("======================================");

        OrderService service = new OrderService();

        // Process all orders
        service.processAllOrders(orders);

        // Display total revenue
        System.out.println("Total Revenue : Rs. "
                + service.getTotalRevenue(orders));

        // Display total number of orders
        FoodOrder.displayTotalOrders();
    }
}
