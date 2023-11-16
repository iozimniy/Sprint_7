package samokat.orders;

import java.util.List;

public class OrdersList {
    private List<OrderInBase> orders;

    public OrdersList() {
    }

    public OrdersList(List<OrderInBase> orderInBaseList) {
        this.orders = orderInBaseList;
    }

    public List<OrderInBase> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderInBase> orders) {
        this.orders = orders;
    }
}
