package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;

public class TestConfig {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;//заимпортили статическую переменную
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationForUdemyCourse = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")//add params
                .addCookie("testCookie")//add params
                .build();

        RestAssured.requestSpecification = requestSpecificationForUdemyCourse;
    }
}
