import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

 public class FirstTest extends TestConfig {

     @Test //gUnit annotations run test
     public void myFirstTest()  {
         given().log().uri(). //добавили лог на валидацию
          when().get(SWAPI_GET_PEOPLE + 1). //эндпоинт + параметр
                 then().log().body().statusCode(200);//залогировали ответ
     }
 }
