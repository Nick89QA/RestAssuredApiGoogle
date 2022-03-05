import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTest extends TestConfig {

     @Test //gUnit annotations run test
     public void myFirstTest()  {
         given().log().uri(). //добавили лог на валидацию
          when().get(SWAPI_GET_PEOPLE + 1). //эндпоинт + параметр
                 then().log().body().statusCode(201);//залогировали ответ
     }

     @Test
     public void getSomeFieldInResponseAssertion() {
         given().spec(requestSpecificationForSwapiTests).log().uri().
           when().get(SWAPI_PATH).
                 then().body("people", equalTo("https://swapi.co/api/people/1")).log().body();
     }
 }
