package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.IOException;

public class POST_request {

    @Test
    public void postRequest(){
        String s = "{\"USER\":\"ADMIN\"}";

        RestAssured.baseURI = getURL ( "URL" );

        RequestSpecification request = RestAssured.given ();
        Response response = request.contentType ( ContentType.JSON )
                .body ( s )
                .request ( Method.POST,"/post");

        System.out.println (response.jsonPath ().get ("USER"));


    }

    public String getURL(String url) {
        String VALUE = null;
        try {
            VALUE = GetProp.fromFile ( "C:\\Users\\Krishnaa\\IdeaProjects\\SDET_API\\src\\test\\data\\initialProps.properties" ).getValue ( url);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return VALUE;
    }
}
