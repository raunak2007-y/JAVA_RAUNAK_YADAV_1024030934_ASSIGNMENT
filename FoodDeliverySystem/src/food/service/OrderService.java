package food.service;

import food.model.FoodOrder;
import food.model.Discountable;
import food.utility.OrderUtility;

public class OrderService {

    // Process and display all orders
    public void processAllOrders(FoodOrder[] orders) {

        for (FoodOrder order : orders) {

            if (order != null) {

                // Validate customer name
                if (!OrderUtility.validateCustomerName(
                        order.getCustomerName())) {

                    System.out.println("Invalid customer name");
                    continue;
                }

                // Validate amount
                if (!OrderUtility.validateAmount(
                        order.getAmount())) {

                    System.out.println("Invalid amount");
                    continue;
                }

                // Display order bill
                OrderUtility.generateOrderSummary(order);
            }
        }
    }

    // Calculate total revenue
    public double getTotalRevenue(FoodOrder[] orders) {

        double total = 0.0;

        for (FoodOrder order : orders) {

            if (order == null) {
                continue;
            }

            double discount = 0.0;

            if (order instanceof Discountable) {
                discount = ((Discountable) order).applyDiscount();
            }

            total += order.getAmount()
                    - discount
                    + order.calculateDeliveryCharge();
        }

        return total;
    }
}
