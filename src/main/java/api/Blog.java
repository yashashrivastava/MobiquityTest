package api;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Blog {

    String endpointUrl;

    public Blog(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public Response getProfile() {
        return given().
                baseUri(endpointUrl).
                when().
                get("/profile");
    }

    public Response getPosts() {
        return given().
                baseUri(endpointUrl).
                when().
                get("/posts");
    }

}
