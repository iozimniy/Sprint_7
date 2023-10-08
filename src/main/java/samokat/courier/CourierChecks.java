package samokat.courier;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;

public class CourierChecks {
    public int assertLoginCourierSuccessfuly(ValidatableResponse login) {
        int id = login
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");
        return id;
    }

    public void notFoudnCourier(ValidatableResponse login) {
        login.assertThat()
                .body("message", equalTo("Учетная запись не найдена"))
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    public void notEnougthDataForLogin(ValidatableResponse login) {
        login.assertThat()
                .body("message", equalTo("Недостаточно данных для входа"))
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST);
    }

    public void assertCreatedCourierSuccessfully(ValidatableResponse response) {
        boolean created = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");

        assert created;
    }

    public void assertNoTwoCanBeTheSame(ValidatableResponse response) {
        response.assertThat()
                .body("message", equalTo("Этот логин уже используется"))
                .statusCode(HttpURLConnection.HTTP_OK)
        ;
    }

    public void notEnougthDataForCreate(ValidatableResponse response) {
        response.assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST);

    }


}
