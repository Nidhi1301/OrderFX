/**
 * Project - final
 * Name - NidhiNidhi 
 *  Date - April,10 2020
 * This part of coding will get the values and set in files.
 */
package content;

public class Order {

    private String orderId;
    private String customerId;
    private String product;
    private String shipping;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

}
