package utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class getPassword {
    public static String getUserPassword(String email, String key) throws Exception {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImRoaW5lc2gucEBrbm93bGVkZ2VxLmNvbSIsImlhdCI6MTcyNjcyNzE2MSwiZXhwIjoxNzI2NzU1OTYxfQ.G7ZjWm04fLHXtJ1vcQtuIMJEd5nio_gBsyFhq2_Ob_E";
        String BASE_URL = "https://app.globalskillnet.com";
        String itemValue = null;
        RestAssured.config = RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .get(BASE_URL + "/v1/users/get/user-details")
                .then()
                .extract()
                .response();
        String responseBody = response.asString();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode finalNode = rootNode.path("final");
            for (JsonNode userNode : finalNode) {
                String currentEmail = userNode.path("email").asText().trim().toLowerCase();
                System.out.println("currentEmail>>>>" + currentEmail);
                email = email.trim().toLowerCase();
                System.out.println("email>>>>" + email);
                System.out.println("email.equals(currentEmail)>>>>" + email.equals(currentEmail));
                if (email.equals(currentEmail)) {
                    itemValue = userNode.path(key).asText().trim();
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception("Username is not registerd");
        }
        return itemValue;
    }
}
