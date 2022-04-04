package apiTests;


import groovy.json.JsonOutput;
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
    String username = "bmartini";
    String password = "123456";
    String token = "";


    public String lerJson(String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get((caminhoJson))));
    }
    @Test (priority = 0)
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
    @Test(priority = 1,dependsOnMethods = {"incluirUser"})
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
    @Test(priority = 2, dependsOnMethods = {"consultarUser"})
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
                .body("message", is(Integer.toString(userId)))
        ;
    }
    @Test(priority = 3,dependsOnMethods = {"alterarUser"})
    public void deletarUser() {
        given()
                .contentType("application/json")
                .log().all()
                .when()
                .delete(uri + "/" + username)
                .then()
                .log().all()
                .statusCode(200)

        ;
    }
    @Test
        public void login(){
String mensagem =


            given()
                    .contentType(appjson)
                    .log().all()

                .when()
                    .get(uri + "/login?username="+ username + "&password=" + password)

                .then()
                    .log().all()
                    .statusCode(200)
                    .body("code",is(200))
                    .body("type",is("unknown"))
                .extract()
                    .path("message");

System.out.println("a mensagem e:"+ mensagem);
        token = mensagem.substring(23);
        System.out.println("o token e:" + token);

                    }

    }
