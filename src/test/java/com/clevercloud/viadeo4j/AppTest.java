package com.clevercloud.viadeo4j;

import com.clevercloud.viadeo4j.json.LocationConverter;
import com.clevercloud.viadeo4j.json.UserConverter;
import com.clevercloud.viadeo4j.models.Location;
import com.clevercloud.viadeo4j.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        String userJson = "{\"id\":\"jrcDnheuoOrIrjehecwgsyvoAc\",\"type\":\"USER\","
           + "\"name\":\"Julien Durillon\",\"link\":\"http://www.viadeo.com/profile/0027h6c0celspqg\","
           + "\"updated_time\":\"2008-10-04T12:56:12+02:00\",\"gender\":\"M\",\"nickname\":\"julien.durillon\","
           + "\"first_name\":\"Julien\",\"last_name\":\"Durillon\",\"picture_small\":\"http://www.viadeo.com/servlet/photo?memberId=0027h6c0celspqg&ts=946681200000&type=1&gender=2\","
           + "\"picture_large\":\"http://www.viadeo.com/servlet/photo?memberId=0027h6c0celspqg&ts=946681200000&type=0&gender=2\","
           + "\"headline\":\"développeur, kan OP\",\"presentation\":\"\",\"interest\":\"\","
           + "\"location\":{\"city\":\"nantes\",\"zipcode\":\"44\",\"country\":\"France\",\"area\":\"Pays de la Loire\",\"timezone\":\"(GMT+01:00) Bruxelles, Copenhague, Madrid, Paris\","
           + "\"latitude\":\"\",\"longitude\":\"\"},\"language\":\"fr\",\"distance\":0}";

        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserConverter()).registerTypeAdapter(Location.class, new LocationConverter()).create();
        System.out.println(gson.fromJson(userJson, User.class));
        assertTrue(true);
    }

    public void testApp2() {
        String locationJson = "{\"city\":\"nantes\",\"zipcode\":\"44\",\"country\":\"France\",\"area\":\"Pays de la Loire\",\"timezone\":\"(GMT+01:00) Bruxelles, Copenhague, Madrid, Paris\","
           + "\"latitude\":\"\",\"longitude\":\"\"}";

        Logger.getAnonymousLogger().info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Gson gson = new GsonBuilder().registerTypeAdapter(Location.class, new LocationConverter()).create();
        System.out.println(gson.fromJson(locationJson, Location.class));
        assertTrue(true);

    }
}
