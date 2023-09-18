package auth;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import utils.ConfigurationUtils;

public class AuthTokenProvider {
    private static final String AUTH_URL = ConfigurationUtils.getBaseURI("Booking_Auth_URL");

    public static String getAuthToken() {
        // Make a POST request to obtain the authorization token
        String contentType = "application/json";
        String requestBody = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";
        Response response = RestAssured
                .given()
                .header("Content-Type", contentType)
                .body(requestBody)
                .post(AUTH_URL);

        // Extract and return the authorization token from the response
        return response.jsonPath().getString("token");
//        String tempAuth="f622829808b7336";
//        return tempAuth;
    }
}
