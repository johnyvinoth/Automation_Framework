package endpoints;

import utils.ConfigurationUtils;

public class APIEndpoints {
    //    Following is for Booking API
    public static final String BOOKING_BASE_URI= ConfigurationUtils.getBaseURI("BaseURL_Booking");
//    public static final String GET_BOOKING_DETAILS=BOOKING_BASE_URI;
//    public static final String GET_BOOKING_IDS=BOOKING_BASE_URI+"/booking/";

//    Following is for Users API
    public static String UserDetailsEndPoint(int userId)
    {
        return BOOKING_BASE_URI+userId;
    }
    public static String GetBookingBaseURL()
    {
        return BOOKING_BASE_URI;
    }
    public static final String USERS="/public/v2/users";
}
