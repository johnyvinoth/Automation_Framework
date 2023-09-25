package utils;

import auth.AuthTokenProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static endpoints.APIEndpoints.*;

public class APIUtils {

    private static final String CONTENT_TYPE = "application/json";
    private static final String BASE_URL = GetBookingBaseURL();
    private static RequestSpecification requestSpec;

    static {
        RestAssured.baseURI = BASE_URL;
        String authToken=AuthTokenProvider.getAuthToken();
//        System.out.println("AuthToken: "+authToken);
        requestSpec = RestAssured.given()
                .header("Authorization", "Bearer " + authToken) // Set your authentication token here
//                .log().all()
                .header("Content-Type", CONTENT_TYPE);

    }

    public static Response get(String endpoint) {
//        System.out.println(requestSpec.header());
        return requestSpec.get(endpoint);
    }

    public static Response getWithParams(String endpoint, String paramName, String paramValue) {
        return requestSpec.queryParam(paramName, paramValue).get(endpoint);
    }

    public static Response post(String endpoint, String requestBody) {
        return requestSpec.body(requestBody).post(endpoint);
    }

    public static Response put(String endpoint, String requestBody) {
        return requestSpec.body(requestBody).put(endpoint);
    }

    public static Response delete(String endpoint) {
        return requestSpec.delete(endpoint);
    }

    // Add methods for other HTTP methods (PUT, DELETE, etc.) if needed

    // You can also add other common utility methods here
}
