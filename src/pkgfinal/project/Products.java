
package pkgfinal.project;


public class Products {
    private String code;
    private String name;
    private double price;
    private int quantity;
   
    private String status;

    public Products(String code, String name, double price, int quantity, String status, String trim) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status=status;
    }

    /**
     *
     * @return
     */
 
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }

    Object getcode() {
       return code; 
    }
}