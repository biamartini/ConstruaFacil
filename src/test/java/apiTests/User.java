package apiTests;


import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class User {
    String uri = "https://petstore.swagger.io/v2/user";
    String appjson = "application/json";
    int petId = 1030;
    int userId = 2200;
    String username = "martini";

    public String lerJson(String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get((caminhoJson))));
    }
    @Test
    public void incluirUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user.json");
        given()
                .contentType(appjson)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .statusCode(200)
                .log().all()
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message",is(Integer.toString(userId)))

                ;

    }
    @Test
    public void consultarUser(){
        given()
                .contentType(appjson)
                .log().all()
            .when()
                .get(uri + "/" + username)
            .then()
                .log().all()
                .statusCode(200)
                .body("firstName", is("bianca"))
                .body("lastName", is("Martini"))
        ;

    }
    @Test
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newuser.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
            .when()
                .put(uri + "/" + username)
            .then()
                .statusCode(200)
                .log().all()
                .body("username",is("martini"))
        ;
    }
    @Test
    public void deletarUser(){
        given()
                .contentType("application/json")
                .log().all()
                .when()
                .delete(uri + "/" + username)
                .then()
                .log().all()
                .statusCode(404)

        ;
    }
   }