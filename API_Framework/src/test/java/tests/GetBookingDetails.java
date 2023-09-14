package tests;

import io.restassured.response.Response;
import models.BookingDetailsResponse;
import utils.APIUtils;
import utils.DeserializationUtils;

import java.util.List;
import java.util.Random;

public class GetBookingDetails {
    public static void GetBookingDetails(String authToken,Integer bookingId) {

        int selectedBookingId = 0;
        if (bookingId != 0) {
            selectedBookingId = bookingId;
            System.out.println("The userId queried is: " + selectedBookingId);
        } else {
            List<Integer> availableBookingIds = APIUtils.getAvailableBookingIds();
            if (!availableBookingIds.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(availableBookingIds.size());
                selectedBookingId = availableBookingIds.get(randomIndex);
                System.out.println("No Booking id provided hence a random bookingId is used, the random id is :" + selectedBookingId);


            } else {
                System.out.println("No available booking IDs found.");
                return; // Exit the test if no booking IDs are available
            }
        }
        Response response = APIUtils.getBooking(selectedBookingId, authToken);
        String jsonResponse = response.getBody().asString();

        System.out.println("The status code is: " + response.getStatusCode());
        System.out.println(jsonResponse);

        BookingDetailsResponse responseObject = DeserializationUtils.deserializeFromJson(jsonResponse, BookingDetailsResponse.class);
        System.out.println("The details on the response object is: " + responseObject);
        assert responseObject != null;
        System.out.println(responseObject.getBookingdates());

    }


}
