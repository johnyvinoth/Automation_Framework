package tests;

import api.APITestBase;
import auth.AuthTokenProvider;
import io.restassured.response.Response;
import models.BookingDetailsResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.APIUtils;
import utils.DeserializationUtils;

public class apiTestCases extends APITestBase {
    private static String authToken;
@BeforeClass
public void setup()
{
    authToken= AuthTokenProvider.getAuthToken();
}
    @Test
    public void TestGetBookingDetails(){
        int userId=1437;
//        String endpoint= APIEndpoints.UserDetailsEndPointsEndPoint(userId);

        Response response = APIUtils.getBooking(userId,authToken);
        String jsonResponse=response.getBody().asString();
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(jsonResponse);

        BookingDetailsResponse responseObject= DeserializationUtils.deserializeFromJson(jsonResponse, BookingDetailsResponse.class);
        System.out.println("The details on the response object is: "+responseObject);
//        assert responseObject != null;
//        System.out.println(responseObject.getBookingdates());
    }

}
