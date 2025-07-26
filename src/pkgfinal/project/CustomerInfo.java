
package pkgfinal.project;

public class CustomerInfo {
     
        private String cusName;
        private String cusEmail;
        private long cusContact;
        private String cusAddress;
        
        public CustomerInfo(String cusName, String cusEmail, long cusContact, String cusAddress) {
            
            this.cusName = cusName;
            this.cusEmail = cusEmail;
            this.cusContact = cusContact;
            this.cusAddress = cusAddress;
        }
        
        public String getCusName() { return cusName; }
        public String getCusEmail() { return cusEmail; }
        public long getCusContact() { return cusContact; }
        public String cusAddString() { return cusAddress; }
}
