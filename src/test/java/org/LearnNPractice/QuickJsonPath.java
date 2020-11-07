package org.LearnNPractice;

import io.restassured.path.json.JsonPath;

public class QuickJsonPath {

    public static void main(String[] args) {

        String jsonText  = "{\"n1\":\"{\"name\":\"phani\",\"age\":\"21\",\"city\":\"Eluru\"}\",\"n2\":\"{\"name\":\"RRR\",\"age\":\"33\",\"city\":\"ss\"}\"}";

        JsonPath js = new JsonPath ( jsonText );
        System.out.println (js.get ());

    }
}
