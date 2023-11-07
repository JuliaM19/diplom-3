package ya.practicum;

import ya.practicum.model.UserRequest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public final class Utils {

    public static String randomName() {
        return randomAlphabetic(5);
    }

    public static String randomEmail() {
        return randomAlphabetic(5) + "@yandex.ru";
    }

    public static String randomPassword(int length) {
        return randomAlphanumeric(length);
    }

    public static UserRequest createRandomUser() {
        return new UserRequest(
                randomName(),
                randomEmail(),
                randomPassword(6)
        );
    }
}
