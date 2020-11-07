package org.LearnNPractice;

import static  io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UDEMY_RahulShetty_22 {

    @Test
     public void testAPI22(){
        // resource =
//        baseURI = "https://gorest.co.in/";
//        Response resp = given ().request ( Method.GET,"public-api/users");
//        System.out.println (resp.jsonPath ().getString ( "$"));
//
//
//        given ().log ().all ().request ( Method.GET,"public-api/users").then ().assertThat ().statusCode ( 200 );

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        RestAssured.useRelaxedHTTPSValidation();

        String getResp = given().log().all().queryParam ( "key", "qaclick123" )
                    .queryParam ( "place_id","0b0527f8e94325446957e89e9b059b58" )
                    .when().get ("maps/api/place/get/json/")
                    .then ().extract ().response ().asString ();

        System.out.println ("=======================");
            System.out.println (getResp);
        System.out.println ("=======================");


        JsonPath js = new JsonPath ( getResp );
        String address = js.getString ( "address" )+" avenue";
        System.out.println (address);
        System.out.println ("=======================");



        String output = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \""+address+"\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://yahoo.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n" +
                        "").when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode ( 200 ).body ( "scope",equalTo ( "APP" ) ).extract ().response ().asString (); //.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        //; //.body("scope", equalTo("APP"))
                System.out.println(output);
        JsonPath jso = new JsonPath ( output );
        System.out.println (">> "+jso.getString ( "place_id" ));

        given ().log ().all ().body ( "{\n" +
                                      "\"place_id\" :\""+ jso.getString ( "place_id" ) +"\",\n" +
                                      "\"address\" :\"Winter Walk USA 70 - P\",\n" +
                                      "\"key\" :\"qaclick123\"\n" +
                                      "}" )
                .when ().put ("maps/api/place/update/json")
                .then ().assertThat ().log ().all ().statusCode ( 200 ).body ( "msg",equalTo ( "Address successfully updated" ) );


        System.out.println ("[*][*][*][*][*][*][*]");


        String getResp1 = given().log().all().queryParam ( "key", "qaclick123" )
                .queryParam ( "place_id",jso.getString ( "place_id" ))
                .when().get ("maps/api/place/get/json/")
                .then ().extract ().response ().asString ();

        System.out.println ("=======================");
        System.out.println (getResp1);
        System.out.println ("=======================");


    }

}


