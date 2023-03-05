package in.reqres.tests;

import in.reqres.models.response.UserDataResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static in.reqres.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Tag("API")
@Epic("REST API")
@Feature("Хранение пользовательских данных")
@Owner("andryushchenkoka")
public class UserTests extends BaseTest {

    @ParameterizedTest(name = "с userId = {0}")
    @DisplayName("Получить данные существующего пользователя")
    @Story("Получить данные пользователя")
    @ValueSource(ints = {
            1, 5, 12
    })
    public void getUserByIdTest(int userId) {

        step("Запрос пользовательских данных", () -> {
            useSpecs(requestSpec(endpointConfig.getBaseURL()), responseSpec200());
            UserDataResponse userData = given()
                    .param("id", userId)
                    .when()
                    .get(endpointConfig.getSingleUserEndpoint())
                    .then().log().all()
                    .extract().jsonPath().getObject("data", UserDataResponse.class);
            Assertions.assertNotNull(userData.getFirst_name());
            Assertions.assertNotNull(userData.getLast_name());
            Assertions.assertTrue(userData.getEmail().endsWith("@reqres.in"));
        });
    }

    @ParameterizedTest(name = "с невалидным userId = {0}")
    @DisplayName("Получить данные несуществующего пользователя")
    @Story("Получить данные пользователя")
    @ValueSource(ints = {
            0, 13
    })
    public void userNotFoundByIdTest(int userId) {
        useSpecs(requestSpec(endpointConfig.getBaseURL()), responseSpec404());
        Response response = given()
                .param("id", userId)
                .when()
                .get(endpointConfig.getSingleUserEndpoint())
                .then().log().all()
                .extract().response();
        Assertions.assertEquals("{}", response.path("").toString());
    }

    @ParameterizedTest(name = "с userId = {0}")
    @DisplayName("Удаление пользователя")
    @Story("Удаление пользователя")
    @ValueSource(ints = {
            0, 5
    })
    public void deleteUserTest(int userId) {
        step("Удалить пользователя", () -> {
            useSpecs(requestSpec(endpointConfig.getBaseURL()), responseSpec204());
            given()
                    .when()
                    .param("id", userId)
                    .delete(endpointConfig.getSingleUserEndpoint())
                    .then().log().all();
        });
    }
}
