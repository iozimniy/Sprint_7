package samokat.orders;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

public class OrderChecks {

    public void assertGetOrdersSuccessfullly(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK);
    }

    static int assertCreateOrderSuccessfully(ValidatableResponse response) {
        int track = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("track")
        ;
        return track;
    }

    public static void assertListFull(OrdersList list) {
        assert(list.getOrders().size() > 0);
    }
}
