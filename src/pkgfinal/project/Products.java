
package pkgfinal.project;


public class Products {
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Products(String code, String name, double price, int quantity, String category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    /**
     *
     * @return
     */
 
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    Object getcode() {
       return code; 
    }
}