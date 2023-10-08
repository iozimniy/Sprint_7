package samokat.orders;

import io.qameta.allure.Step;
import org.junit.Test;

public class TestGetOrdersList extends samokat.Clients {

    private OrderClient client = new OrderClient();
    private OrderChecks check = new OrderChecks();

    @Test
    public void testGetOrdersList() {
        //создаём тестовые данные
        OrderGenerator.generateOrders();

        //Получаем список заказов
        var list = client.getOrdersList();

        //Проверяем, что лист не пустой
        check.assertListFull(list);
    }

    @Test
    public void testStatusGetOrderList() {
        //создаём тестовые данные
        OrderGenerator.generateOrders();

        //отправляем запрос
        var response = client.getOrders();

        //проверяем код ответа
        check.assertGetOrdersSuccessfullly(response);
    }
}
