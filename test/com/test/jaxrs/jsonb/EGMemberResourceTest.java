/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.jaxrs.jsonb;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agupgupt
 */
public class EGMemberResourceTest {

    public EGMemberResourceTest() {
    }

    @Test
    public void testGetOneEGMember() {
        Response response = ClientBuilder.newClient().
                target("http://localhost:8080/jaxrs-jsonb/api/persons/first").
                request().get();

        assertEquals(response.getStatus(), 200);
        assertEquals(response.readEntity(String.class), "{\"fname\":\"Martin\",\"lname\":\"Grebac\",\"org\":\"Oracle\"}");
    }

    @Test
    public void testGetAllEGMembers() {
        Response response = ClientBuilder.newClient().
                target("http://localhost:8080/jaxrs-jsonb/api/persons/all").
                request().get();

        assertEquals(response.getStatus(), 200);
        assertEquals(response.readEntity(String.class),
                "[{\"fname\":\"Dmitry\",\"lname\":\"Kornilov\",\"org\":\"Oracle\"},{\"fname\":\"Roman\",\"lname\":\"Grigoriadi\",\"org\":\"Oracle\"},{\"fname\":\"Martin\",\"lname\":\"Grebac\",\"org\":\"Oracle\"},{\"fname\":\"Martin\",\"lname\":\"Vojtek\",\"org\":\"Oracle\"},{\"fname\":\"Martin\",\"lname\":\"Saly\",\"org\":\"Individual Member\"},{\"fname\":\"Gegor\",\"lname\":\"Zurowski\",\"org\":\"Individual Member\"},{\"fname\":\"Inderjeet\",\"lname\":\"Singh\",\"org\":\"Individual Member\"},{\"fname\":\"Eugen\",\"lname\":\"Cepoi\",\"org\":\"Individual Member\"},{\"fname\":\"Przemyslaw\",\"lname\":\"Bielicki\",\"org\":\"Individual Member\"},{\"fname\":\"Kyung\",\"lname\":\"Koo Yoon\",\"org\":\"TmaxSoft, Inc.\"},{\"fname\":\"Otavio\",\"lname\":\"Santana\",\"org\":\"Individual Member\"},{\"fname\":\"Rick\",\"lname\":\"Curtis\",\"org\":\"IBM\"},{\"fname\":\"Alexander\",\"lname\":\"Salvanos\",\"org\":\"Individual Member\"},{\"fname\":\"Romain\",\"lname\":\"Manni-Bucau\",\"org\":\"Tomitribe\"}]");
    }

    @Test
    public void testPostOneEGMember() {
        Response response = ClientBuilder.newClient().
                target("http://localhost:8080/jaxrs-jsonb/api/persons").
                request().post(Entity.json("{\"fname\":\"Martin\",\"lname\":\"Grebac\",\"org\":\"Oracle\"}"));

        assertEquals(response.getStatus(), 202);
    }

    @Test
    public void testPostManyEGMembers() {
        Response response = ClientBuilder.newClient().
                target("http://localhost:8080/jaxrs-jsonb/api/persons/all").
                request().post(Entity.json("[{\"fname\":\"Dmitry\",\"lname\":\"Kornilov\",\"org\":\"Oracle\"},{\"fname\":\"Roman\",\"lname\":\"Grigoriadi\",\"org\":\"Oracle\"}]"));

        assertEquals(response.getStatus(), 202);
    }
}
