package tests;

import api.APITestBase;
import auth.AuthTokenProvider;
import io.restassured.response.Response;
import jdk.jfr.StackTrace;
import models.BookingDetailsResponse;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BookingService;
import utils.APIUtils;
import utils.DeserializationUtils;
import utils.exceptions.NotFoundException;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static services.BookingService.*;

public class apiTestCases extends APITestBase {
    private static String authToken;

//    @BeforeClass
////    public void setup() {
////        authToken = AuthTokenProvider.getAuthToken();
////    }


    public static void GetBookingDetails(Integer bookingId) {
        try {

            int selectedBookingId = 0;
            if (bookingId != 0) {
                selectedBookingId = bookingId;
                System.out.println("The userId queried is: " + selectedBookingId);
            } else {
                List<Integer> availableBookingIds = BookingService.getAvailableBookingIds();
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
            Response response = getBookingDetails(selectedBookingId);
            String jsonResponse = response.getBody().asString();

            System.out.println("The status code is: " + response.getStatusCode());

            System.out.println(jsonResponse);

//            Check if the status is code is 404
            if (response.statusCode() == 200) {
                BookingDetailsResponse responseObject = DeserializationUtils.deserializeFromJson(jsonResponse, BookingDetailsResponse.class);
                System.out.println("The details on the response object is: " + responseObject);
                assert responseObject != null;
                System.out.println(responseObject.getBookingdates());
            } else if (response.statusCode() == 404) {
                throw new NotFoundException("The requested booking ID is not found.");

            } else {
                throw new Exception();
            }
        } catch (NotFoundException e) {
            // Handle the custom exception for 404
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @Test(enabled = false)
    public void TestNoPOJO() {
        String jsonResponse = getRandomBookingDetailsResponse();
        Map<String, Object> dataMap = deserializeJsonResponse(jsonResponse);

        System.out.println(dataMap);
        Map<String,Object> bookingdates= (Map<String, Object>) dataMap.get("bookingdates");
        System.out.println("Deposit Paid :"+bookingdates.get("checkin"));


    }
    @Test
    public void TestCreateBooking()
    {
        String jsonResponse=postCreateBooking();
        System.out.println(jsonResponse);

    }


    @Test(enabled = false)
    public static void TestGetBookingDetails() {
//        GetBookingDetails(0);
//        GetBookingDetails(5254544);
//        TestNoPOJO(3276);


    }
//
}
