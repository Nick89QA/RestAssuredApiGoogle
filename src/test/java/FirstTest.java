import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTest extends TestConfig {

    @Test //gUnit annotations run test
    public void myFirstTest() {
        given().log().uri(). //добавили лог на валидацию
                when().get(SWAPI_GET_PEOPLE + 1). //эндпоинт + параметр
                then().log().body().statusCode(201);//залогировали ответ
    }

    @Test
    public void getSomeFieldInResponseAssertion() {
        given().spec(requestSpecificationForSwapiTests).log().uri().
                when().get(SWAPI_PATH).
                then().body("people", equalTo("https://swapi.co/api/people/")).log().body();
    }

    @Test
    public void getSomeFieldInResponseWithIndexAssertion() {
        given().spec(requestSpecificationForSwapiTests).log().uri().
                when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
                then()
                .body("count", equalTo(87))
                .body("results.name[0]", equalTo("Luke Skywalker"))//matcher проверка полей на соответствие
                .log().body();
    }


    @Test
    public void getAllDataFromRequest() {
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri().
                        when().get(SWAPI_PATH).
                        then().log().all().extract().response();
        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);

    }

    @Test
    public void getCookieFromResponse() {
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri().
                        when().get(SWAPI_PATH).
                        then().log().all().extract().response();
        Map<String, String> allCookie = response.getCookies();
        System.out.println("allCookie--->" + allCookie);

        String someCookie = response.getCookie("__cfduid");
        System.out.println("someCookie--->" + someCookie);
    }

    @Test
    public void getHeadersFromResponse() {
        Response response =
                given().spec(requestSpecificationForSwapiTests).log().uri().
                        when().get(SWAPI_PATH).
                        then().extract().response();
        Headers headers = response.getHeaders();
        System.out.println("headers--->" + headers);

        String contentType = response.getContentType();
        System.out.println("contentType--->" + contentType);

    }

}
