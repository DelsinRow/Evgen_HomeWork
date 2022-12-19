package DenisTasks.streams;

import java.util.Collection;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private Integer tier;

    public Customer() {

    }
    public Customer(int id, String name, Integer tier, List<Customer> customerList) {
        this.id = id;
        this.name = name;
        this.tier = tier;

        customerList.add(this);
    }

   static public Customer getCustomerToOrder(String name, List<Customer> customerList) {
        Customer chooseCustomer = new Customer();
        for (Customer customer : customerList) {
           if(customer.getName().equals(name)) {
               chooseCustomer = customer;
           }
        }
        return chooseCustomer;
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

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer: " + "id " + id + ", tier " + tier;
    }
}
