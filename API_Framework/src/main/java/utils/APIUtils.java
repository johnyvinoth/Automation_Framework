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
        String authToken = AuthTokenProvider.getAuthToken();
//        System.out.println("AuthToken: "+authToken);
        requestSpec = RestAssured.given()
                .cookie("token", authToken) // Set your authentication token here
                .accept("application/json")
//                .log().all()
                .contentType(CONTENT_TYPE);

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
//        Response response = requestSpec.body(requestBody).put(endpoint);
//        printCurlCommand(requestBody, "put", endpoint);
//        return response;
        return requestSpec.body(requestBody).put(endpoint);
    }

    public static Response delete(String endpoint) {
        return requestSpec.delete(endpoint);
    }

    // Add methods for other HTTP methods (PUT, DELETE, etc.) if needed

    // You can also add other common utility methods here

    private static void printCurlCommand(String requestBody, String method, String endpoint) {
        String curlCommad = generateCurclCommand(method.toUpperCase(), endpoint, requestBody);
        System.out.println("cURL Command:\n" + curlCommad);
    }

    private static String generateCurclCommand(String method, String endpoint, String requestBody) {
        // Initialize a StringBuilder to build the cURL command
        StringBuilder curlCommand = new StringBuilder();

        // Append the cURL command with the basic structure
        curlCommand.append("curl -X ").append(method);

        // Add the endpoint URL
        curlCommand.append(" '").append(endpoint).append("'");

        // Add headers (e.g., Authorization and Content-Type)
        curlCommand.append(" -H 'Authorization: Bearer ").append(AuthTokenProvider.getAuthToken()).append("'");
        curlCommand.append(" -H 'Content-Type: ").append(CONTENT_TYPE).append("'");

        // If the method is POST or PUT and there's a request body, add it
        if (("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) && requestBody != null) {
            // Escape single quotes in the JSON body
            requestBody = requestBody.replace("'", "\\'");
            // Add the request body
            curlCommand.append(" -d '").append(requestBody).append("'");
        }

        // Return the constructed cURL command as a String
        return curlCommand.toString();
    }
}
