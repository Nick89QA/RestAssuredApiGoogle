import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.JSONPLACEHOLDER_GET;
import static constants.Constants.Actions.JSONPLACEHOLDER_PUT;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolder extends TestConfig {

    @Test
    public void GET() {
     given().queryParam("postId", 1).log().uri().
             when().get(JSONPLACEHOLDER_GET).
             then().log().body().statusCode(200);

    }

   @Test
   public void Put() {
    String putBodyJson ="{\n" +
            "\"id\":1,\n" +
            "\"title\":\"foo\",\n" +
            "\"body\":\"bar\",\n" +
            "\"userId\":1\n" +
            "}";
    given().body(putBodyJson).log().uri().
            when().put(JSONPLACEHOLDER_PUT).
            then().log().body().statusCode(200);
   }

}
