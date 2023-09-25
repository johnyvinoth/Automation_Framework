package endpoints;

import utils.ConfigurationUtils;

public class APIEndpoints {
    //    Following are the endpoints for Booking API
    public static final String BOOKING_BASE_URI= ConfigurationUtils.getBaseURI("BaseURL_Booking");

    public static String GetBookingBaseURL()
    {
        return BOOKING_BASE_URI+"booking";
    }
    public static String CreateBookingEndPoint()
    {
        return BOOKING_BASE_URI+"booking";
    }
    public static String UpdateBookingEndPoint(int userId)
    {
        return BOOKING_BASE_URI+"booking";
    }
    public static String DeleteBookingEndPoint(int userId)
    {
        return BOOKING_BASE_URI+"booking";
    }



    //    Following are the endpoints for Users API
    public static final String USERS="/public/v2/users";
}
