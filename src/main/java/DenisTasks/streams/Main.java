package DenisTasks.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        System.out.println("\nПолучить список товаров из категории «Watch» с ценой > 130");
        List<Product> firstList =  allProductList().stream().filter(product -> product.getCategory().equals("Watch") & product.getPrice() > 130).toList();
        System.out.println(firstList);

        System.out.println("\nПолучить список заказов с товарами, относящимися к категории «Watch»");
        List<Order> secondList = new ArrayList<>();
        for (Order order : allOrderList()) {
            for(Product product : allProductList()) {
                if(product.getCategory().equals("Watch")) {
                    break;
                }
                break;
            }
            secondList.add(order);
        }
        System.out.println(secondList);


        System.out.println("\nПолучите список товаров с категорией «Notebook», а затем примените скидку 25%");
        List<Product> thirdList = allProductList().stream()
                .filter(product -> product.getCategory().equals("Notebook"))
                .peek(product -> product.setPrice(product.getPrice() * 0.75)).toList();

        System.out.println(thirdList);


        System.out.println("\nПолучите список товаров, заказанных клиентом уровня 3 в период с 01 марта 2022 г. по 30 июня 2022 г.");
        List<Order> orderMarchJune = allOrderList().stream().filter(order ->
                order.getCustomer().getName().equals("BronzeClient") &
                order.getOrderDate().isAfter(LocalDate.of(2022,3, 1)) &
                order.getOrderDate().isBefore(LocalDate.of(2022, 6, 30))).toList();
        orderMarchJune.stream().forEach(order -> System.out.println(order.getProductsList()));


        System.out.println("\nПолучите самые дешевые товары категории «Phone»");
        List<Double> prices = new ArrayList<>();
        allProductList().stream()
                .filter(product -> product.getCategory().equals("Phone"))
                .forEach(product -> prices.add(product.getPrice()));
        List<Product> sixthList = allProductList().stream()
                .filter(product -> product.getCategory().equals("Phone") & product.getPrice() < cheapPrice(prices)).toList();

        System.out.println(sixthList);

        System.out.println("\nПолучите 5 последних заказа");
        List<Order> sortedAllOrderList = allOrderList().stream().sorted((s1, s2) -> s1.getOrderDate().compareTo(s2.getOrderDate())).toList();
        int idx = sortedAllOrderList.size() - 5;
        sortedAllOrderList.stream().skip(idx).forEach(System.out::println);


        System.out.println("\nПолучите список заказов, которые были заказаны 12 июня 2022 года. Выведите все записи заказов в консоль. Верните список продуктов.");
        List<Order> eighth = allOrderList().stream().filter(order -> order.getOrderDate().equals(LocalDate.of(2022, 6, 12))).toList();
        System.out.println("Заказы от 12.06.22: " + eighth + " Товары в заказе:");
        eighth.stream().flatMap(order -> order.getProductsList().stream()).forEach(System.out::println);


        System.out.println("\nРассчитайте общую сумму всех заказов, сделанных в июне");
        List<Order> orderJune = allOrderList().stream().filter(order -> order.getOrderDate().getMonth().name().equals("JUNE")).toList();
        double sum = 0;
        for (Order order : orderJune) {
            for(Product product : allProductList()) {
                sum = sum + product.getPrice();
                }
            }
        System.out.println(sum);


        System.out.println("\nРассчитать среднюю сумму заказов за 20 февраля");
        List<Order> tenth = allOrderList().stream().filter(order -> order.getOrderDate().equals(LocalDate.of(2022, 2, 20))).toList();

        for (Order order : tenth) {
            List<Double> priceFebList = new ArrayList<>();
            order.getProductsList().stream().forEach(product -> priceFebList.add(product.getPrice()));
            System.out.println("Middle price by order ID " + order.getId() + ": " + cheapPrice(priceFebList));

        }

        System.out.println("Получите Map'у с идентификатором заказа и количеством продуктов в заказе");
        Map<Integer,Integer> idCountMap = new HashMap<>();
        allOrderList().forEach(order -> idCountMap.put(order.getId(), order.getProductsList().size()));
        System.out.println(idCountMap);

        System.out.println("Получите Map'у с заказом и общей суммой товаров");
        Map<Order,Double> orderSum = new HashMap<>();
        allOrderList().forEach(order -> {
            double price = 0;
                for(Product product : order.getProductsList()) {
                    price = price + product.getPrice();
                }
            orderSum.put(order, price);
        });
        System.out.println(orderSum);


        System.out.println("\nПолучите самый дорогой продукт по категории «Phone»");
        List<Product> phoneList =  allProductList().stream().filter(product -> product.getCategory().equals("Phone")).toList();
        //List <Product> sortedPhoneByPrice = phoneList.stream().sorted((s1, s2) -> s2.getPrice().compareTo(s1.getPrice())).toList();
        Product expensivePhone = phoneList.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
        System.out.println(expensivePhone);


        System.out.println("\nДобавить null к какой-нибудь коллекции и использовать Optional");

    }

   static double cheapPrice(List<Double> priceList) {
        double sum = 0;
        for(double price : priceList) {
            sum += price;
        }
        return sum/priceList.size();
    }


    static List<Product> allProductList() {
        List<Product> productList = new ArrayList<>();
        Product notebookHP = new Product(1, "HP", "Notebook", 199.99, productList);
        Product phoneSamsung = new Product(2, "Samsung", "Phone", 129.99, productList);
        Product phoneApple = new Product(3, "Apple", "Phone", 209.99, productList);
        Product phoneXiaomi = new Product(4, "Xiaomi", "Phone", 89.99, productList);
        Product notebookXiaomi = new Product(5, "Xiaomi", "Notebook", 900.99, productList);
        Product pencilApple = new Product(6, "Apple", "Pencil", 100.99, productList);
        Product watchApple = new Product(7, "Apple", "Watch", 500.99, productList);
        Product watchXiaomi = new Product(8, "Xiaomi", "Watch", 120.99, productList);
        Product watchSamsung = new Product(9, "Samsung", "Watch", 310.99, productList);
        Product notebookSamsung = new Product(10, "Samsung", "Notebook", 830.99, productList);

        return productList;
    }

    static List<Product> bigGiftPack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(2, allProductList()));
        productList.add(Product.getProduct(3, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(7, allProductList()));
        productList.add(Product.getProduct(9, allProductList()));
        productList.add(Product.getProduct(10, allProductList()));

        return productList;
    }
    static List<Product> smallGiftPack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(1, allProductList()));
        productList.add(Product.getProduct(4, allProductList()));
        productList.add(Product.getProduct(5, allProductList()));
        productList.add(Product.getProduct(8, allProductList()));

        return productList;
    }
    static List<Product> someStrangePack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(3, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(8, allProductList()));

        return productList;
    }
    static List<Product> oneElsePack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(1, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(4, allProductList()));

        return productList;
    }
    static List<Product> ChristmasPack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(3, allProductList()));
        productList.add(Product.getProduct(2, allProductList()));
        productList.add(Product.getProduct(8, allProductList()));
        productList.add(Product.getProduct(2, allProductList()));

        return productList;
    }
    static List<Product> wtfPack() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));

        return productList;
    }

    static List<Customer> customerList() {
        List<Customer> customerList = new ArrayList<>();

        Customer goldClient = new Customer(1, "GoldClient", 1, customerList);
        Customer silverClient = new Customer(2, "SilverClient", 2, customerList);
        Customer simpleClient = new Customer(3, "BronzeClient", 3, customerList);

        return customerList;
    }

    static List<Order> allOrderList() {
        List<Order> orderList = new ArrayList<>();

        Order order001 = new Order(1,
                LocalDate.of(2022, 1, 9),
                LocalDate.of(2022, 1, 10), "ready",
                Customer.getCustomerToOrder("GoldClient", customerList()),
                bigGiftPack(), orderList);

        Order order002 = new Order(2,
                LocalDate.of(2022, 2, 20),
                LocalDate.of(2022, 2, 21), "ready",
                Customer.getCustomerToOrder("SilverClient", customerList()),
                smallGiftPack(), orderList);

        Order order003 = new Order(3,
                LocalDate.of(2022, 3, 17),
                LocalDate.of(2022, 3, 21), "ready",
                Customer.getCustomerToOrder("SilverClient", customerList()),
                bigGiftPack(), orderList);

        Order order004 = new Order(4,
                LocalDate.of(2022, 4, 7),
                LocalDate.of(2022, 4, 8), "ready",
                Customer.getCustomerToOrder("BronzeClient", customerList()),
                bigGiftPack(), orderList);

        Order order009 = new Order(9,
                LocalDate.of(2022, 9, 12),
                LocalDate.of(2022, 9, 13), "ready",
                Customer.getCustomerToOrder("BronzeClient", customerList()),
                wtfPack(), orderList);

        Order order005 = new Order(5,
                LocalDate.of(2022, 5, 12),
                LocalDate.of(2022, 5, 13), "ready",
                Customer.getCustomerToOrder("GoldClient", customerList()),
                smallGiftPack(), orderList);

        Order order006 = new Order(6,
                LocalDate.of(2022, 6, 12),
                LocalDate.of(2022, 6, 13), "ready",
                Customer.getCustomerToOrder("BronzeClient", customerList()),
                someStrangePack(), orderList);

        Order order007 = new Order(7,
                LocalDate.of(2022, 7, 12),
                LocalDate.of(2022, 7, 13), "ready",
                Customer.getCustomerToOrder("SilverClient", customerList()),
                smallGiftPack(), orderList);

        Order order008 = new Order(8,
                LocalDate.of(2022, 8, 12),
                LocalDate.of(2022, 8, 13), "ready",
                Customer.getCustomerToOrder("SilverClient", customerList()),
                oneElsePack(), orderList);

        Order order012 = new Order(12,
                LocalDate.of(2022, 12, 9),
                LocalDate.of(2022, 12, 9), "ready",
                Customer.getCustomerToOrder("GoldClient", customerList()),
                ChristmasPack(), orderList);

        Order order010 = new Order(10,
                LocalDate.of(2022, 10, 12),
                LocalDate.of(2022, 10, 13), "ready",
                Customer.getCustomerToOrder("GoldClient", customerList()),
                bigGiftPack(), orderList);

        Order order011 = new Order(11,
                LocalDate.of(2022, 11, 12),
                LocalDate.of(2022, 11, 13), "ready",
                Customer.getCustomerToOrder("BronzeClient", customerList()),
                ChristmasPack(), orderList);

        Order order013 = new Order(13,
                LocalDate.of(2022, 6, 12),
                LocalDate.of(2022, 6, 14), "ready",
                Customer.getCustomerToOrder("BronzeClient", customerList()),
                ChristmasPack(), orderList);

        Order order014 = new Order(14,
                LocalDate.of(2022, 2, 20),
                LocalDate.of(2022, 2, 21), "ready",
                Customer.getCustomerToOrder("SilverClient", customerList()),
                ChristmasPack(), orderList);


        return orderList;
    }

    static Optional<Product> optProduct () {
        return Optional.of(Product.getProduct(5,allProductList()));
    }
}
