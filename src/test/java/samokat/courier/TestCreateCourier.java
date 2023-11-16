package samokat.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class TestCreateCourier {

    private final CourierClient client = new CourierClient();
    private final CourierChecks checks = new CourierChecks();
    protected int courierId;

    @After
    public void deleteCourier() {
        client.delete(courierId);
    }


    //Проверяем, что курьер создаётся
    @Test
    public void createCourier() {
        //создём курьера
        var courier = GenerationCourier.generateRandomCourier();
        ValidatableResponse response = client.create(courier);
        checks.assertCreatedCourierSuccessfully(response);

        //логиним его, чтобы получить id для удаления
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);
        courierId = checks.assertLoginCourierSuccessfuly(login);
    }

    //Проверяем, что два одинаковых курьера не создаются
    @Test
    public void noTwoCanBeTheSame() {
        //создаём курьера
        var courier = GenerationCourier.generateRandomCourier();
        client.create(courier);
        ValidatableResponse theSameCourier = client.create(courier);

        //логиним его, чтобы получить id
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);
        courierId = checks.assertLoginCourierSuccessfuly(login);

        //проверяем, что приходит нужный код и мессадж
        checks.assertNoTwoCanBeTheSame(theSameCourier);
    }

    // проверяем, что нельзя создать пользователя без логина
    @Test
    public void noCreateWithoutLogin() {
        //создаём курьера без логина
        var courier = GenerationCourier.generationWithoutLogin();
        ValidatableResponse response = client.create(courier);

        //проверяем, что курьер не создался
        checks.notEnougthDataForCreate(response);
    }

    // проверяем, что нельзя создать пользователя без пароля
    @Test
    public void noCreateWithoutPassword() {
        //создаём курьера без пароля
        var courier = GenerationCourier.generationWithoutPassword();
        ValidatableResponse response = client.create(courier);

        //проверяем, что курьер не создался
        checks.notEnougthDataForCreate(response);
    }
}
