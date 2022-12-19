package DenisTasks.streams;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private String category;
    private Double price;

    public Product() {

    }
    public Product(int id, String name, String category, Double price, List<Product> productList) {

        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;

        productList.add(this);

    }

    static public Product getProduct(int id, List<Product> allProductList) {
        Product chooseProduct = new Product();
        for (Product product : allProductList) {
            if(product.getId() == id) {
                chooseProduct = product;
            }
        }
        return chooseProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + "id " + id + ", category='" + category + '\'';
    }
}
