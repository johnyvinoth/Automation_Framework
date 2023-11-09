package auth;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import jdk.jfr.StackTrace;
import utils.ConfigurationUtils;

import java.io.IOException;
import java.net.SocketException;

public class AuthTokenProvider {
    private static final String AUTH_URL = ConfigurationUtils.getBaseURI("Booking_Auth_URL");

    public static String getAuthToken() {
        // Make a POST request to obtain the authorization token
        String contentType = "application/json";
        String requestBody = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";
        try
        {

        Response response = RestAssured
                .given()
                .header("Content-Type", contentType)
                .body(requestBody)
//                .log().all()
                .post(AUTH_URL);

        //TODO: Need to check why this getAuthToken function is failing during this post operation.

        // Extract and return the authorization token from the response
        return response.jsonPath().getString("token");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
//        String tempAuth="f622829808b7336";
//        return tempAuth;
    }
    public static String getHardCodeAuthToken()
    {
        return ConfigurationUtils.getResource("AuthToken");
    }
}
