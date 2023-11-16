package samokat.orders;

public class OrderGenerator {

    private static final OrderClient client = new OrderClient();

    private static final Object[][] dataOrders = new Object[][]{
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

    public static void generateOrders() {
        int j = 0;
        while (j < dataOrders.length - 1) {
            Order order = new Order(dataOrders[j]);
            client.create(order);
            j++;
        }
    }
}
