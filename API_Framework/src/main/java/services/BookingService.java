package services;

import endpoints.APIEndpoints;
import io.restassured.response.Response;
import models.BookingDetailsResponse;
import utils.APIUtils;
import utils.DeserializationUtils;
import java.util.List;
import java.util.Random;

import static endpoints.APIEndpoints.GetBookingBaseURL;


public class BookingService {

    /**
     * Retrieves the available booking ids.
     *
     * @return list of available booking ids.
     */
    public static List<Integer> getAvailableBookingIds()
    {
        Response response= APIUtils.get(GetBookingBaseURL());
        return response.jsonPath().getList("bookingid");
    }
        /**
         * Retrieves booking details by sending a GET request to the API endpoint.
         *
         * @param bookingId The unique identifier for the booking to retrieve.
         * @param authToken The authentication token required for accessing the API.
         * @return The response from the API, including status code, headers, and the response body.
         */

    public static Response getBookingDetails(int userId) {
//        return APIUtils.get(BookingDetailsEndPoint(userId));
        return APIUtils.get(String.valueOf(userId));

    }
    /**
     * Retrieves the details of a random booking id from the available booking ids.
     *
     * @return Retrieves a String with JSON body of the response with the details of a random booking id
     * from the available booking ids.
     */
    public static String getRandomBookingDetailsResponse() {
        List<Integer> availableBookingIds = BookingService.getAvailableBookingIds();
        String jsonResponse = null;
        if (!availableBookingIds.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availableBookingIds.size());
            int selectedBookingId = availableBookingIds.get(randomIndex);
            System.out.println("Random bookingId is used is :" + selectedBookingId);

            Response response = BookingService.getBookingDetails(selectedBookingId);

            jsonResponse = response.getBody().asString();
            System.out.println("The status code is: " + response.getStatusCode());

//            System.out.println(jsonResponse);

        }
        return jsonResponse;
    }
    public static String postCreateBooking(String body)
    {
        Response response= APIUtils.post(APIEndpoints.CreateBookingEndPoint(),body);
        return response.getBody().asString();
    }
        /**
         * Retrieves booking details and parses the response into a BookingDetailsResponse object.
         *
         * @param bookingId The unique identifier for the booking to retrieve.
         * @param authToken The authentication token required for accessing the API.
         * @return An object representing the booking details if successful, or null in case of an error.
         */
    public static BookingDetailsResponse getBookingDetailsAsObject(int bookingId) {

        Response response = BookingService.getBookingDetails(bookingId);
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

