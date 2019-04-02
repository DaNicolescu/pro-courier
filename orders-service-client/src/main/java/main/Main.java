package main;

import com.procourier.model.Order;
import http.GetOrderByIdClient;
import http.GetOrdersClient;

public class Main {
    public static void main(String[] args) {
        GetOrderByIdClient client = new GetOrderByIdClient();
        GetOrdersClient client2 = new GetOrdersClient();

        Order order = client.getOrder(1L);
        List<Order> order2 = client2.getOrders();

        System.out.println(order);

        System.out.println(order2);
    }
}
