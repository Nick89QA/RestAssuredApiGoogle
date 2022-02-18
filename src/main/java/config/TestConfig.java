package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.REQUSTBIN_URL;

public class TestConfig {



    protected RequestSpecification requestSpecificationXML = new RequestSpecBuilder()
            .addHeader("Content-Type","application/xml")//add params
            .addCookie("testCookieXML")//add params
            .setBaseUri(REQUSTBIN_URL) // add url
            .build();

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;//заимпортили статическую переменную
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")//add params
                .addCookie("testCookieJSON")//add params
                .build();
// Этот запрос создан для набора уникальных и общих параметров
        RestAssured.requestSpecification = requestSpecificationJson;

    }
}
