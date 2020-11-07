package org.example;

import java.io.*;
import java.util.Properties;

public class GetProp {

    private  static Properties prop = null;

    public static GetProp fromFile(String file) throws IOException {
        if (prop == null){
            prop = new Properties ();
            System.out.println (file);
            prop.load ( new FileInputStream ( file ) );
        }


        return new GetProp();
    }

    public String getValue(String key){
        return (String) prop.get ( key );
    }


}
