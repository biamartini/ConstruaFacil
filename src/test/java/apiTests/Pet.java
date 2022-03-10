package apiTests;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class Pet {

    String uri = "https://petstore.swagger.io/v2/pet";
    int petId = 1030;
    //Gerki
    //Given - Dado
    //.When - Quando
    //.Then - Entao

    // funcoes de apoio


      public String lerJson(String caminhoJson) throws IOException {

          return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test (priority = 0)
    public void incluirPet() throws IOException { //create - post
        String jsonBody = lerJson("src/test/resources/data/pet.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .post(uri)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is("mumi"))
                .body("category.name", is("cat"))
                .body("tags.name[0]", stringContainsInOrder("vermifugado"))

        ;
    }
@Test(priority = 1,dependsOnMethods = {"incluirPet"})
    public void consultarPet() {
    //String petId = petId;
    given()
            .contentType("application/json")
            .log().all()
        .when()
            .get(uri + "/" + petId)
        .then()
            .log().all()
            .statusCode(200)
            .body("name",is("mumi"))
            .body("status",is("available"))
    ;
}
@Test(priority = 1, dependsOnMethods = {"consultarPet"})
    public void alterarPet() throws IOException {
    String jsonBody = lerJson("src/test/resources/data/newpet.json");
    given()

        .contentType("application/json")
        .log().all()
        .body(jsonBody)
    .when()
        .put(uri)
    .then()
        .statusCode(200)
        .log().all()
        .body("status",is("sold"))
        ;
}
@Test
        public void excluirPet(){
    Object integer;
    given()
            .contentType("application/json")
            .log().all()
        .when()
            .delete(uri + "/" + petId)
        .then()
            .log().all()
            .statusCode(200)
            .body("code",is(200))
            .body("type",is("unknown"))
            .body("message",is(Integer.toString(petId)));
}
}