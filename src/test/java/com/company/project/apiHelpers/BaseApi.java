package com.company.project.apiHelpers;

import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

class BaseApi {

    Response getRequest(String endpoint, String token) {

        return given().header("Authorization", token)
                .when().get(endpoint)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract().response();
    }

    String returnAuthToken(String endpoint, String login, String password) {

        JSONObject jsonObj = new JSONObject()
                .put("email", login)
                .put("password", password);
        return "Token " + given().contentType("application/json").body(jsonObj.toString())
                .when().post(endpoint)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract().path("access_token").toString();
    }

    Response addRequest(String endpoint, JSONObject jsonObj, String token) {

        return given().contentType("application/json").header("Authorization", token).body(jsonObj.toString())
                .when().post(endpoint)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract().response();
    }

    void deleteRequest(String endpoint, int enityId, String token) {

        given().header("Authorization", token)
                .when().delete(endpoint + enityId)
                .then()
                .log().ifError()
                .statusCode(200);
    }
}
