package in.reqres.tests;

import in.reqres.models.request.LoginRequest;
import in.reqres.models.request.RegisterRequest;
import in.reqres.models.response.LoginFailedResponse;
import in.reqres.models.response.LoginSuccessResponse;
import in.reqres.models.response.RegisterFailedResponse;
import in.reqres.models.response.RegisterSuccessResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static in.reqres.helpers.Endpoint.*;
import static in.reqres.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Tag("API")
@Epic("REST API")
@Feature("Система авторизации пользователя")
@Owner("andryushchenkoka")
public class AuthTests extends BaseTest {

    @Test
    @Story("Вход в систему")
    @DisplayName("Вход с полным и валидным набором данных")
    public void userLoginByFullDataTest() {

        step("Запрос на авторизацию", () -> {
            LoginRequest userLogin = new LoginRequest("eve.holt@reqres.in", "cityslicka");
            LoginSuccessResponse successResponse = given()
                    .spec(request)
                    .when()
                    .body(userLogin)
                    .post(LOGIN_ENDPOINT)
                    .then()
                    .spec(responseSpec200())
                    .log().all()
                    .extract().as(LoginSuccessResponse.class);
            Assertions.assertNotNull(successResponse.getToken());
        });
    }

    @Test
    @Story("Вход в систему")
    @DisplayName("Вход без пароля")
    public void userLoginWithoutPasswordTest() {

        step("Запрос на авторизацию", () -> {
            LoginRequest userLogin = new LoginRequest("peter@klaven");
            LoginFailedResponse failedResponse = given()
                    .spec(request)
                    .when()
                    .body(userLogin)
                    .post(LOGIN_ENDPOINT)
                    .then()
                    .spec(responseSpec400())
                    .log().all()
                    .extract().as(LoginFailedResponse.class);
            Assertions.assertEquals("Missing password", failedResponse.getError());
        });
    }

    @Test
    @Story("Регистрация нового пользователя")
    @DisplayName("Регистрация с полным и валидным набором данных")
    public void userRegisterByFullDataTest() {

        step("Запрос на регистрацию", () -> {
            RegisterRequest userRegister = new RegisterRequest("eve.holt@reqres.in", "pistol");
            RegisterSuccessResponse successResponse = given()
                    .spec(request)
                    .when()
                    .body(userRegister)
                    .post(REGISTER_ENDPOINT)
                    .then()
                    .spec(responseSpec200())
                    .log().all()
                    .extract().as(RegisterSuccessResponse.class);
            Assertions.assertTrue(successResponse.getId() > 0);
            Assertions.assertNotNull(successResponse.getToken());
        });
    }

    @Test
    @Story("Регистрация нового пользователя")
    @DisplayName("Регистрация без пароля")
    public void userRegisterWithoutPasswordTest() {

        step("Запрос на регистрацию", () -> {
            RegisterRequest userRegister = new RegisterRequest("sydney@fife");
            RegisterFailedResponse failedResponse = given()
                    .spec(request)
                    .when()
                    .body(userRegister)
                    .post(REGISTER_ENDPOINT)
                    .then()
                    .spec(responseSpec400())
                    .log().all()
                    .extract().as(RegisterFailedResponse.class);
            Assertions.assertEquals("Missing password", failedResponse.getError());
        });
    }
}
