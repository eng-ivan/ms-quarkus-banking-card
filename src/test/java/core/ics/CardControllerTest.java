package core.ics;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CardControllerTest {

    @Test
    void test(){
        given()
                .when()
                .get("/api/test")
                .then()
                .statusCode(200);
    }
}