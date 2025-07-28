
package pkgfinal.project;

public class CustomerInfo {
    private String cusName;
    private String cusEmail;
    private long cusContact;
    private String cusAddress;
    private String cusStatus;

    public CustomerInfo(String cusName, String cusEmail, long cusContact, String cusAddress, String cusStatus) {
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.cusContact = cusContact;
        this.cusAddress = cusAddress;
        this.cusStatus = cusStatus;
    }

    public String getCusName() { return cusName; }
    public String getCusEmail() { return cusEmail; }
    public long getCusContact() { return cusContact; }
    public String getCusAddress() { return cusAddress; }
    public String getCusStatus() { return cusStatus; }
}