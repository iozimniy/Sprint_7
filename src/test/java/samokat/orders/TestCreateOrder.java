package samokat.orders;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import samokat.Clients;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class TestCreateOrder {

    private final OrderClient client = new OrderClient();
    private final OrderChecks checks = new OrderChecks();

    protected int track;

    private Order order;

    public TestCreateOrder(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }


    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {
                        "Марк Аврелий",
                        "Антонин",
                        "Москва",
                        "Смоленская",
                        "+7 900 300 60 60",
                        4,
                        "2023-10-10",
                        "Нет на свете плохой судьбы или несчастливого жребия",
                        new String[]{"BLACK"}
                },
                {
                        "Луций Анней",
                        "Сенека",
                        "Москва",
                        "Боровицкая",
                        "+7 900 444 77 33",
                        2,
                        "2023-10-11",
                        "Уходи в себя насколько можешь",
                        new String[]{"GRAY", "BLACK"}
                },
                {
                        "Диоген",
                        "Лаэртский",
                        "Москва",
                        "Беломорская",
                        "+7 900 404 77 33",
                        3,
                        "2023-10-11",
                        "Днём с огнём",
                        new String[]{""}
                }
        };
    }

    @Test
    public void testCreateOrder() {

        //order = new Order("Mark", "Dow", "Москва, 10 Downing Street", "Аннино", "+7 800 389 35 35", 3, "2023-10-10", "Hello", new String[]{"BLACK"});

        ValidatableResponse response = client.create(order);
        track = checks.assertCreateOrderSuccessfully(response);
        assert track != 0;
    }
}
