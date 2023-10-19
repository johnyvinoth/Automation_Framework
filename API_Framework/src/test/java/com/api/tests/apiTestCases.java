package com.api.tests;

import api.APITestBase;
import io.qameta.allure.*;
import io.restassured.response.Response;
import models.BookingDetailsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BookingService;
import utils.DeserializationUtils;
import utils.JsonUtils;
import utils.exceptions.NotFoundException;
//import io.qameta.allure.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static services.BookingService.*;
import static utils.JsonUtils.getNestedValueFromJson;

public class apiTestCases extends APITestBase {
    private static String authToken;
    public static int bookingid;

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

    public static String getBookingDetails_New(int bookingId) {
        Response response = null;
        if (bookingId != 0) {
            response = getBookingDetails(bookingId);
//            response = BookingService.getBookingDetails(bookingId);
        }

//        DynamicJSONModel dataMap = deserializeJsonResponse_new(response.getBody().asString());
//        return dataMap;
        assert response != null;
        return response.getBody().asString();
    }

    @Test(enabled = true, groups = "api_booking")
//    @Description("This is a sample test description.")
//    @Description("Test")
    public static void TestNoPOJO() {
        String jsonResponse = getRandomBookingDetailsResponse();
        Map<String, Object> dataMap = deserializeJsonResponse(jsonResponse);
//        DynamicJSONModel dataMap = deserializeJsonResponse_new(jsonResponse);

        System.out.println(dataMap);
        Map<String, Object> bookingdates = (Map<String, Object>) dataMap.get("bookingdates");
//        DynamicJSONModel bookingdates = (DynamicJSONModel) dataMap.get("bookingdates");
        System.out.println("Checkin Date :" + bookingdates.get("checkin"));


    }

    @Test(enabled = true, groups = "api_booking")
    @Step("Test Step")
    @Description("Test Description")
    public static void DummyTest() {
        System.out.println("Dummy Test pass");

        Assert.assertTrue(true);
        logger.debug("Debug Message");
        logger.info("Info Message");
        logger.error("Error message");
    }

    @Test(enabled = true, groups = "api_booking")
    @Step("Test Step")
    @Description("Test Description")
    public void TestCreateBooking() {
        Map<String, Object> model = new HashMap<>();

        // Add key-value pairs to represent the JSON structure
        model.put("firstname", "Naethan");
        model.put("lastname", "Johny vinoth");
//        model.put("bookingdates", new HashMap<String, Object>() {{
//            put("checkin", "2023-01-01");
//            put("checkout", "2023-01-10");
//        }});
        model.put("additionalneeds", "Breakfast");

//  Create a nested map for bookingdates.

        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        // Add the nested map to the main model
        model.put("bookingdates", bookingdates);


        String jsonResponse = postCreateBooking(model);

//        Following code to print the response JSON in readable format.
        String prettyPrintedJson = JsonUtils.prettyPrintJson(jsonResponse);
        System.out.println(prettyPrintedJson);

        // Getting the values under each field for validation.
        Double bookingIdDouble = JsonUtils.getNestedValueFromJson(jsonResponse, "bookingid");
        if (bookingIdDouble != null) {
            bookingid = bookingIdDouble.intValue();
        } else {
            // Handle the case where "bookingid" is not found or is null
        }
//        bookingid = ((Double) Objects.requireNonNull(JsonUtils.getNestedValueFromJson(jsonResponse, "bookingid"))).intValue();

        String firstname = JsonUtils.getNestedValueFromJson(jsonResponse, "booking", "firstname");
        String checkingDate = JsonUtils.getNestedValueFromJson(jsonResponse, "booking", "bookingdates", "checkin");
        Double totalPrice = JsonUtils.getNestedValueFromJson(jsonResponse, "booking", "totalprice");


        System.out.println("BookingId :" + bookingid);
        System.out.println("Firstname :" + firstname);
        System.out.println("Checkin Date :" + checkingDate);
        System.out.println("Total Price :" + totalPrice);

        Assert.assertEquals(model.get("firstname"), firstname);
        Assert.assertEquals(bookingdates.get("checkin"), checkingDate);

    }


    @Test(enabled = true, dependsOnMethods = "TestCreateBooking", groups = "api_booking")
//    @Description("test")
    public static void TestGetBookingDetails() {

//        GetBookingDetails(bookingid);
//        GetBookingDetails(0);
        String jsonResponse = getBookingDetails_New(bookingid);
        String prettyPrintedJson = JsonUtils.prettyPrintJson(jsonResponse);
        System.out.println(prettyPrintedJson);
        Double bookingIdDouble = JsonUtils.getNestedValueFromJson(jsonResponse, "bookingid");
        if (bookingIdDouble != null) {
            bookingid = bookingIdDouble.intValue();
        } else {
            // Handle the case where "bookingid" is not found or is null
        }
//        bookingid = ((Double) Objects.requireNonNull(JsonUtils.getNestedValueFromJson(jsonResponse, "bookingid"))).intValue();

        String firstname = JsonUtils.getNestedValueFromJson(jsonResponse, "firstname");
        String checkingDate = JsonUtils.getNestedValueFromJson(jsonResponse, "bookingdates", "checkin");
        Double totalPrice = JsonUtils.getNestedValueFromJson(jsonResponse, "totalprice");


        System.out.println("BookingId :" + bookingid);
        System.out.println("Firstname :" + firstname);
        System.out.println("Checkin Date :" + checkingDate);
        System.out.println("Total Price :" + totalPrice);

//        TestNoPOJO(bookingid);


//        System.out.println("The details created is: " + model.getModel());

    }

    @Test(enabled = true, groups = "api_booking")
    public static void TestGetNestedValueFromJSON() {
        String filePath = "src/main/java/models/createBookingResp.json";
        String jsonResponse = JsonUtils.readJsonFromFile(filePath);

        System.out.println(jsonResponse);


        Double bookingId = getNestedValueFromJson(jsonResponse, "bookingid");

    }

    @Test(enabled = true, priority = 1, dependsOnMethods = "TestCreateBooking", groups = "api_booking")
    public static void TestUpdateBooking() {
        try {

            Map<String, Object> payload = new HashMap<>();
            payload.put("firstname", "Johny");
            payload.put("lastname", "Xavier");
            payload.put("additionalneeds", "UpdatedRecord");

            String jsonResponse = BookingService.putUpdateBooking(payload, bookingid);
            String prettyPrintedJson = JsonUtils.prettyPrintJson(jsonResponse);
            System.out.println(prettyPrintedJson);

            Assert.assertNotNull(jsonResponse, "The expected value is not null but received null response.");
            if (jsonResponse != null) {

                Double bookingIdDouble = JsonUtils.getNestedValueFromJson(jsonResponse, "bookingid");
                if (bookingIdDouble != null) {
                    bookingid = bookingIdDouble.intValue();
                } else {
                    // Handle the case where "bookingid" is not found or is null
                }
                String firstname = JsonUtils.getNestedValueFromJson(jsonResponse, "firstname");
                String checkingDate = JsonUtils.getNestedValueFromJson(jsonResponse, "bookingdates", "checkin");
                Double totalPrice = JsonUtils.getNestedValueFromJson(jsonResponse, "totalprice");
                String additionalneeds = JsonUtils.getNestedValueFromJson(jsonResponse, "additionalneeds");

                System.out.println("BookingId :" + bookingid);
                System.out.println("Firstname :" + firstname);
                System.out.println("Checkin Date :" + checkingDate);
                System.out.println("Total Price :" + totalPrice);
                System.out.println("Total Price :" + additionalneeds);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true, priority = 2, dependsOnMethods = "TestCreateBooking", groups = "api_booking")
    public static void TestDelete() {

        String jsonResponse = BookingService.DELETEBooking(bookingid);
        String prettyPrintJson = JsonUtils.prettyPrintJson(jsonResponse);
        System.out.println("The response for the delete request is: " + prettyPrintJson);

    }

    // TODO : Need to add profiles in the POM.XML to load different details based on the profile. Going to have one profile for Booking API and one for Users API.
//
}
