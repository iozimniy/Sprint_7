package samokat.orders;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.junit.Assert.assertTrue;

public class OrderChecks {

    static int assertCreateOrderSuccessfully(ValidatableResponse response) {
        int track = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("track");
        return track;
    }

    public static void assertListFull(OrdersList list) {
        assertTrue(list.getOrders().size() > 0);
    }

    public void assertGetOrdersSuccessfullly(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK);
    }
}
