package in.reqres.specs;

import in.reqres.config.EndpointConfiguration;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static in.reqres.helpers.CustomAllureListener.withCustomTemplate;

public class Specs {

    public static RequestSpecification request = with()
            .baseUri(EndpointConfiguration.getBaseUrl())
            .log().all()
            .log().uri()
            .log().method()
            .filter(withCustomTemplate())
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec204() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }

    public static ResponseSpecification responseSpec400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification responseSpec404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }
}