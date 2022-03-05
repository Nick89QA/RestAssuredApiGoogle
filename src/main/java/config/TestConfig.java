package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.*;

public class TestConfig {

    protected RequestSpecification requestSpecificationForSwapiTests = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();


    protected RequestSpecification requestSpecificationXML = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml")//add params
            .addCookie("testCookieXML")//add params
            .setBaseUri(REQUSTBIN_URL) // add url
            .build();

    protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")//add params
            .addCookie("testCookieJSON")//add params
            .setBaseUri(JSON_PLACEHOLDER_URL)
            .build();

    protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;//заимпортили статическую переменную
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationForUdemyCourse = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addCookie("testCookie")
                .build();


// Этот запрос создан для набора уникальных и общих параметров
        RestAssured.requestSpecification = requestSpecificationJson;

    }
}
