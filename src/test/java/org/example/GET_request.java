package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GET_request {

    @Test
    public void getResponse(){

        RestAssured.baseURI  = getURL ( "GET_URL" );
        RequestSpecification httpRequest = RestAssured.given();
        Response httpResponse = httpRequest.request ( Method .GET,RestAssured.baseURI);


        int statusCode = httpResponse.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String contentType = httpResponse.getHeader("Content-type");
        System.out.println (contentType);

        Headers headerList = httpResponse.getHeaders();
        for (Header header : headerList) {
            System.out.println(header.getName() + header.getValue());
        }
        String responseBody = httpResponse.getBody().asString();
        System.out.println (responseBody);

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
