import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.JSONPLACEHOLDER_GET;
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
    String putBodyJson ="";
    given().body().log().uri().
   }

}
