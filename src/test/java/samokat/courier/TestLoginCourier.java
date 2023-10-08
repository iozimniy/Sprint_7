package samokat.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class TestLoginCourier {

    private final CourierClient client = new CourierClient();
    private final CourierChecks checks = new CourierChecks();
    protected int courierId;

    @After
    public void deleteCourier() {
        client.delete(courierId);
    }

    //проверяем, что существующий курьер может авторизоваться
    @Test
    public void loginTest() {
        // создаём курьера
        var courier = GenerationCourier.generateRandomCourier();
        ValidatableResponse response = client.create(courier);

        //пытаемся его авторизовать
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);

        //проверяем, что авторизация прошла успешно и что id не нулевой
        courierId = checks.assertLoginCourierSuccessfuly(login);
        assert courierId != 0;
    }

    //проверяем, что несуществующий курьер не может авторизоваться
    @Test
    public void loginWithoutCourier() {
        //получаем сгенерированные данные
        var courier = GenerationCourier.generateRandomCourier();

        //пытаемся по ним авторизоваться
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);

        //проверяем, что авторизоваться не получилось
        checks.notFoudnCourier(login);

    }

    //проверяем, что без логино авторизоваться нельзя
    @Test
    public void loginWithoutLoginData() {
        //создаём курьера с логином
        var courier = GenerationCourier.generateRandomCourier();
        ValidatableResponse response = client.create(courier);

        //убираем логин из данных
        courier.setLogin("");

        //пытаемся авторизоваться по данным без логина
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);

        //проверяем, что вернулась ошибка
        checks.notEnougthDataForLogin(login);
    }

    //проверяем, что без пароля авторизоваться нельзя
    @Test
    public void loginWithoutPasswordData() {
        //создаём курьера с паролём
        var courier = GenerationCourier.generateRandomCourier();
        ValidatableResponse response = client.create(courier);

        //убираем логин из данных
        courier.setPassword("");

        //пытаемся авторизоваться по данным без пароля
        var authData = AuthData.from(courier);
        ValidatableResponse login = CourierClient.login(authData);

        //проверяем, что вернулась ошибка
        checks.notEnougthDataForLogin(login);
    }

}
