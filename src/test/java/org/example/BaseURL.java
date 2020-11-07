package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class BaseURL
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String VALUE=null;
        String Exp_VALUE="http://postman-echo.com";
        try {
            VALUE = GetProp.fromFile ( "C:\\Users\\Krishnaa\\IdeaProjects\\SDET_API\\src\\test\\data\\initialProps.properties" ).getValue ( "URL" );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        System.out.println (VALUE);

        Assert.assertEquals ( VALUE, Exp_VALUE );


    }
}
