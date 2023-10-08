package samokat.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerationCourier {
    public static Courier generateCourier() {
        return new Courier("Joe", "67hyjll", "Black");
    }

    public static Courier generateRandomCourier() {
        return new Courier("test" + RandomStringUtils.randomAlphanumeric(5, 12), "67hyjll", "Black");
    }

    public static Courier generationWithoutLogin() {
        return new Courier("", "67hyjll", "Black");
    }

    public static Courier generationWithoutPassword() {
        return new Courier("Joe", "", "Black");
    }
}
