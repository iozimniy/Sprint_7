package samokat.courier;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class CourierClient extends samokat.Clients {

    static final String COURIER_URI = "/api/v1/courier";

    public static ValidatableResponse login(AuthData authData) {
        return spec()
                .body(authData)
                .when()
                .post(COURIER_URI + "/login")
                .then().log().all();
    }

    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_URI)
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        return spec()
                .body(Map.of("id", String.valueOf(courierId)))
                .when()
                .delete(COURIER_URI + "/" + courierId)
                .then().log().all();
    }
}
