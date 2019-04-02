package main;

import com.procourier.model.Address;
import com.procourier.model.Buyer;
import com.procourier.model.Courier;
import com.procourier.model.Order;
import com.procourier.model.OrderLine;
import com.procourier.model.Product;
import com.procourier.model.Seller;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();
        Product phone = new Product(1000L, "Huawei P30", "New phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "Old laptop ", 1700L);

        Address emagAddress =
                new Address("Bucuresti", "Bucuresti", "Soseaua Virtutii", "20A");

        Address johnAddress = new Address("Dolj", "Craiova", "Ecaterina Teodoroiu", "11");
        Address proCourierAddress = new Address("Timis", "Timisoara", "AI Cuza", "86");

        Buyer john = new Buyer("John", johnAddress);
        Seller emag = new Seller("Emag", emagAddress);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(olPhone);
        orderLines.add(olLaptop);
        Courier courier =
                new Courier("ProCourier", proCourierAddress, 9L, 13L);
        Order order = new Order(emag, john, courier, orderLines );
        orderService.addOrder(order);
        System.out.println("Order 1 delivered successfully");


        Product fridge = new Product(2000L, "Beko", "big refrigerator", 2700L);
        Product tv = new Product(3000L, "Samsung TV", "nop notch led tv", 1000L);
        Product gamimgPc = new Product(8000L, "Gaming PC", "high end gaming PC", 1500L);

        Address storeAdress =
                new Address("Bucuresti", "Bucuresti", "Stefan cel Mare", "3B");

        Address gigelAddress = new Address("Teleorman", "Videle", "Ecaterina Teodoroiu", "7");
        Address cheapCourierAddress = new Address("Brasov", "Brasov", "Mihai Eminescu", "12");

        Buyer gigel = new Buyer("Gigel", gigelAddress);
        Seller store = new Seller("Store", storeAdress);

        OrderLine olFridge = new OrderLine(fridge, 1L);
        OrderLine olTv = new OrderLine(tv, 5L);
        OrderLine olGamingPc = new OrderLine(gamimgPc, 2L);

        List<OrderLine> orderLines2 = new ArrayList<>();
        orderLines2.add(olFridge);
        orderLines2.add(olTv);
        orderLines2.add(olGamingPc);

        Courier courier2 =
                new Courier("CheapCourier", cheapCourierAddress, 5L, 8L);

        Order order2 = new Order(store, gigel, courier2, orderLines2);
        orderService.addOrder(order2);
        System.out.println("Order 2 delivered successfully");
    }
}
