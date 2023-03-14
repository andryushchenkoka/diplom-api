package in.reqres.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplate;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {

        RestAssured.filters(withCustomTemplate());
    }
}
