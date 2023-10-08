package samokat.orders;

import io.restassured.response.ValidatableResponse;

public class OrderClient extends samokat.Clients {
    public static final String ORDER_PATH = "/api/v1/orders";
    public static final String ORDERSLIST_PATH = "/api/v1/orders";


    public ValidatableResponse getOrders() {
        return specForGet()
                .get(ORDERSLIST_PATH)
                .then()
        ;
    }

    public OrdersList getOrdersList() {
        return specForGet()
                .get(ORDERSLIST_PATH)
                .body().as(OrdersList.class)
        ;
    }

    public ValidatableResponse create(Order order) {
        return spec()
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then().log().all();
    }
}
