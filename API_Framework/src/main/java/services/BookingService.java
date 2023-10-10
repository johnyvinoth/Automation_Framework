package services;

import endpoints.APIEndpoints;
import io.restassured.response.Response;
import models.BookingDetailsResponse;
import utils.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static endpoints.APIEndpoints.GetBookingBaseURL;


public class BookingService {

    /**
     * Retrieves the available booking ids.
     *
     * @return list of available booking ids.
     */
    public static List<Integer> getAvailableBookingIds() {
        Response response = APIUtils.get(GetBookingBaseURL());
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

    /**
     * Sends a POST request to create a booking with the provided JSON data.
     *
     * @param model A Map representing the JSON data structure for creating a booking.
     * @return The JSON response string received from the server.
     */
    public static String postCreateBooking(Map<String, Object> model) {

        Map<String, Object> jsonStructure = SerializationUtils.readModelFromFile(ConfigurationUtils.getModelJsonLocation("CreateBooking_ModelJson"));
        if (jsonStructure != null && model != null) {
            jsonStructure.putAll(model);

        }
        String serializedJson = SerializationUtils.serializeToJson(jsonStructure);
        Response response = APIUtils.post(APIEndpoints.CreateBookingEndPoint(), serializedJson);
        return response.getBody().asString();
    }

    /**
     * Sends a POST request to update a booking with the provided JSON data.
     *
     * @param model A Map representing the JSON data structure for creating a booking.
     * @return The JSON response string received from the server.
     */
    public static String putUpdateBooking(Map<String, Object> model, int bookingId) {

        Map<String, Object> jsonStructure = SerializationUtils.readModelFromFile(ConfigurationUtils.getModelJsonLocation("UpdateBooking_ModelJson"));
        if (jsonStructure != null && model != null) {
            jsonStructure.putAll(model);

        }
        String serializedJson = SerializationUtils.serializeToJson(jsonStructure);
        Response response = APIUtils.put(APIEndpoints.UpdateBookingEndPoint(bookingId), serializedJson);
        if (response.getStatusCode() == 200) {

            System.out.println("The Status code for update request is: " + response.statusCode());
            return response.getBody().asString();
        } else {

            System.out.println("The response for the put request is: " + response.getBody().asString() + " \n and the status code is: " + response.statusCode());
        }
        return null;
    }

    /**
     * Sends a DELETE request to delete a booking id.
     *
     * @param bookingId int booking id to be deleted.
     * @return The JSON response string received from the server.
     */
    public static String DELETEBooking(int bookingId) {
        Response response = APIUtils.delete(APIEndpoints.DeleteBookingEndPoint(bookingId));
        if (response.getStatusCode() == 200 || response.getStatusCode()==201) {

            System.out.println("The Status code for update request is: " + response.statusCode());
            return response.getBody().asString();
        } else {

            System.out.println("The response for the DELETE request is: " + response.getBody().asString() + " \n and the status code is: " + response.statusCode());
        }
        return null;
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

