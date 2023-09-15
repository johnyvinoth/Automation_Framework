package services;

import io.restassured.response.Response;
import utils.APIUtils;
import utils.DeserializationUtils;
import models.BookingDetailsResponse;

import java.util.List;
import java.util.Random;

public class BookingService {
    public static Response getBookingDetails(int bookingId, String authToken) {
        /**
         * Retrieves booking details by sending a GET request to the API endpoint.
         *
         * @param bookingId The unique identifier for the booking to retrieve.
         * @param authToken The authentication token required for accessing the API.
         * @return The response from the API, including status code, headers, and the response body.
         */
        return APIUtils.getBooking(bookingId, authToken);

    }

    public static BookingDetailsResponse getBookingDetailsAsObject(int bookingId, String authToken) {
        /**
         * Retrieves booking details and parses the response into a BookingDetailsResponse object.
         *
         * @param bookingId The unique identifier for the booking to retrieve.
         * @param authToken The authentication token required for accessing the API.
         * @return An object representing the booking details if successful, or null in case of an error.
         */

        Response response = getBookingDetails(bookingId, authToken);
        String jsonResponse = response.getBody().asString();

        System.out.println("The status code is: " + response.getStatusCode());
        System.out.println(jsonResponse);
        BookingDetailsResponse responseObject = DeserializationUtils.deserializeFromJson(jsonResponse, BookingDetailsResponse.class);
        System.out.println("The details on the response object is: " + responseObject);
        assert responseObject != null;
        System.out.println(responseObject.getBookingdates());

        if (response.getStatusCode() == 200) {
            return DeserializationUtils.deserializeFromJson(response.getBody().asString(), BookingDetailsResponse.class);
        } else {
            // Handle error or return null as needed
            return null;
        }
    }
}

