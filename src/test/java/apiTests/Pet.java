package apiTests;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    //Gerki
    //Given - Dado
    //.When - Quando
    //.Then - Entao

    // funcoes de apoio


      public String lerjson(String caminhoJson){

          return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet(){//create - post


    given()
            .contentType("application/json")
            .log().all()
        .when()
            .post("https://petstore.swagger.io/v2/pet")
        .then()
            .log().all()
        ;
}
}
