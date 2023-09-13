package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import endpoints.APIEndpoints;

import static endpoints.APIEndpoints.*;

public class APIUtils {

    private static final String CONTENT_TYPE = "application/json";

    public static Response getBooking(int userId, String authToken) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", CONTENT_TYPE)
                .get(UserDetailsEndPoint(userId));
    }

    public static Response post(String endpoint, String authToken, String requestBody) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", CONTENT_TYPE)
                .body(requestBody)
                .post(GetBookingBaseURL());
    }

    // Add methods for other HTTP methods (PUT, DELETE, etc.) if needed

    // You can also add other common utility methods here
}
