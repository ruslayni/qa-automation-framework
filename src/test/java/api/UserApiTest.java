package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class UserApiTest {

    @Test
    public void getUsers(){
        Response response = given().baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asPrettyString());

    }

//    @Test
//    public void checkFirstUser(){
//        getUsers();
//        Response response = (Response) given().baseUri("https://jsonplaceholder.typicode.com")
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(200)
//                .body("name[0]", equalTo("Leanne Graham"));
//
//    }
}