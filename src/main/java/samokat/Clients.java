package samokat;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Clients {
    static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/";

    public static RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

    public static RequestSpecification specForGet() {
        return given().log().all()
                .baseUri(BASE_URI);
    }
}
