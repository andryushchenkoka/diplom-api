package in.reqres.tests;

import in.reqres.config.EndpointConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplate;

public class BaseTest {

    protected static EndpointConfig endpointConfig;

    @BeforeAll
    public static void beforeAll() {

        endpointConfig = ConfigFactory.create(EndpointConfig.class);
        RestAssured.filters(withCustomTemplate());
    }
}
