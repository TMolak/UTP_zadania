/**
 * @author Molak Tomasz S26635
 */

package zad2;


public class Purchase {

    private String id, name, surname, productName;
    private double price, quantity;

    public Purchase(String id, String name, String surname, String productName, double price, double quantity) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id+";"+ surname+" "+name+";"+ productName+";"+ price+";"+ quantity;
    }
}
