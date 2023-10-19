package lesson4;

public class Order {
    private String orderId;
    private String customerName;
    private String shippingAddress;
    private String paymentMethod;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public static class OrderBuilder {
        private String orderId;
        private String customerName;
        private String shippingAddress;
        private String paymentMethod;

        public OrderBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public OrderBuilder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public OrderBuilder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.orderId = this.orderId;
            order.customerName = this.customerName;
            order.shippingAddress = this.shippingAddress;
            order.paymentMethod = this.paymentMethod;

            return order;
        }
    }
}
