package Builder.requests;

import Builder.PropertyLoader;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Request {
    public String baseUrl = PropertyLoader.getProperty("api.baseUrl");

    public RequestSpecification spec;
    public Response resp;

    public RequestSpecification restAssuredRequest() {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new ErrorLoggingFilter())
                ;
    }

    public String getJson() {
        return resp.then().extract().response().asString();
    }

    public int getStatusCode() {
        return resp.then().extract().response().statusCode();
    }
}
