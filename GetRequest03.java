package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {
  /*  https://restful-booker.herokuapp.com/booking/5 url’ine
    accept type’i “application/json” olan GET request’i yolladigimda
    gelen response’un
    status kodunun 200
    ve content type’inin “application/json”
    ve firstname’in “Susan”
    ve totalprice’in 703
    ve checkin date’in 2015-02-16"oldugunu test edin*/


    @Test
    public void test06(){
        String url="https://restful-booker.herokuapp.com/booking/5";
        Response response=given().when().get(url);
        response.prettyPrint();
        response.then().contentType(ContentType.JSON).statusCode(200);
        response.then().assertThat().body("firstname", Matchers.equalTo("Susan"),
                "totalprice",Matchers.equalTo(703),
                "bookingdates.checkin",Matchers.equalTo("2015-02-16"));


    }
}
