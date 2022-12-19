package DenisTasks.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Получить список товаров из категории «Watch» с ценой > 130
        List<Product> firstList =  allProductList().stream().filter(product -> product.getCategory().equals("Watch") & product.getPrice() > 130).toList();

        // Получить список заказов с товарами, относящимися к категории «"Watch"»
        List<Order> secontList = new ArrayList<>();
        for (Order order : allOrderList()) {
            for(Product product : allProductList()) {
                if(product.getCategory().equals("Watch")) {
                    secontList.add(order);
                }
            }
        }

         // Получите список товаров с категорией «Notebook», а затем примените скидку 25%
        List<Product> fourthtList = allProductList().stream()
                .filter(product -> product.getCategory().equals("Notebook"))
                .peek(product -> product.setPrice(product.getPrice() * 0.75)).toList();

        // Получите список товаров, заказанных клиентом уровня 3 в период с 01 марта 2022 г. по 30 июня 2022 г.

        // Получите самые дешевые товары категории «Phone»
        List<Double> prices = new ArrayList<>();

        allProductList().stream()
                .filter(product -> product.getCategory().equals("Phone"))
                .forEach(product -> prices.add(product.getPrice()));
        List<Product> sixthList = allProductList().stream()
                .filter(product -> product.getCategory().equals("Phone") & product.getPrice() < cheapPrice(prices)).toList();

        // Получите 5 последних заказа

        // Получите список заказов, которые были заказаны 12 июня 2022 года. Выведите все записи заказов в консоль. Верните список продуктов.

        // Рассчитайте общую сумму всех заказов, сделанных в июне

        // Рассчитать среднюю сумму заказов за 20 февраля

        // Получите Map'у с идентификатором заказа и количеством продуктов в заказе

        // Получите Map'у с заказом и общей суммой товаров

        // Получите самый дорогой продукт по категории

        // Добавить null к какой-нибудь коллекции и использовать Optional
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

    static List<Product> goldProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(2, allProductList()));
        productList.add(Product.getProduct(3, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(7, allProductList()));
        productList.add(Product.getProduct(9, allProductList()));
        productList.add(Product.getProduct(10, allProductList()));

        return productList;
    }
    static List<Product> silverProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(1, allProductList()));
        productList.add(Product.getProduct(4, allProductList()));
        productList.add(Product.getProduct(5, allProductList()));
        productList.add(Product.getProduct(8, allProductList()));

        return productList;
    }
    static List<Product> bronzeProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.getProduct(3, allProductList()));
        productList.add(Product.getProduct(6, allProductList()));
        productList.add(Product.getProduct(8, allProductList()));

        return productList;

    }

    static List<Customer> customerList() {
        List<Customer> customerList = new ArrayList<>();

        Customer goldClient = new Customer(1, "GoldClient", 1, customerList);
        Customer silverClient = new Customer(2, "SilverClient", 2, customerList);
        Customer simpleClient = new Customer(3, "SimpleClient", 3, customerList);

        return customerList;
    }

    static List<Order> allOrderList() {
        List<Order> orderList = new ArrayList<>();

        Order order001 = new Order(1,
                LocalDate.of(2022, 2, 20),
                LocalDate.of(2022, 2, 25), "ready",
                Customer.getCustomer("GoldClient", customerList()),
                goldProductList(), orderList);

        Order order002 = new Order(2,
                LocalDate.of(2022, 2, 20),
                LocalDate.of(2022, 2, 23), "ready",
                Customer.getCustomer("SilverClient", customerList()),
                silverProductList(), orderList);

        Order order003 = new Order(3,
                LocalDate.of(2022, 12, 17),
                LocalDate.of(2022, 12, 21), "not ready",
                Customer.getCustomer("BronzeClient", customerList()),
                bronzeProductList(), orderList);

        Order order004 = new Order(4,
                LocalDate.of(2022, 6, 7),
                LocalDate.of(2022, 6, 8), "ready",
                Customer.getCustomer("BronzeClient", customerList()),
                bronzeProductList(), orderList);

        Order order005 = new Order(5,
                LocalDate.of(2022, 6, 12),
                LocalDate.of(2022, 6, 13), "ready",
                Customer.getCustomer("BronzeClient", customerList()),
                bronzeProductList(), orderList);

        return orderList;
    }


}
