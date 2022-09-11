package com.estagio.estudos.BlinksFoodAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class CozinhaTeste  {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void startUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";
    }


    @Test
    public void comeBack_Status_200_in_CozinhaController(){
                RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());

    }
    @Test
    public void contains_nine_Cozinhas_Resources(){
                RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("", Matchers.hasSize(9))
                .body("nome",Matchers.hasItems("Americana","Japonesa"));
    }
    @Test
    public void comeBackStatus201_in_CoxinhasResources(){
            RestAssured.given()
                    .body("{\"nome\": \"Americana\"}")
                    .contentType(ContentType.JSON)
                    .when()
                    .post()
                    .then()
                    .statusCode(HttpStatus.CREATED.value());
    }

}
