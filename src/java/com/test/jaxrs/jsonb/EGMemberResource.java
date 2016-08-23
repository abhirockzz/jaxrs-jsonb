package com.test.jaxrs.jsonb;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author agupgupt
 */
@Path("persons")
public class EGMemberResource {

    @GET
    @Path("first")
    public EGMember get() {
        return new EGMember("Martin", "Grebac", "Oracle");
    }

    @POST
    public Response set(EGMember p) {
        System.out.println(p.toString());
        return Response.accepted().build();
    }

    @GET
    @Path("all")
    public List<EGMember> all() {
        List<EGMember> persons = new ArrayList<>();
        persons.add(new EGMember("Dmitry", "Kornilov", "Oracle"));
        persons.add(new EGMember("Roman", "Grigoriadi", "Oracle"));
        persons.add(new EGMember("Martin", "Grebac", "Oracle"));
        persons.add(new EGMember("Martin", "Vojtek", "Oracle"));
        persons.add(new EGMember("Martin", "Saly", "Individual Member"));
        persons.add(new EGMember("Gegor", "Zurowski", "Individual Member"));
        persons.add(new EGMember("Inderjeet", "Singh", "Individual Member"));
        persons.add(new EGMember("Eugen", "Cepoi", "Individual Member"));
        persons.add(new EGMember("Przemyslaw", "Bielicki", "Individual Member"));
        persons.add(new EGMember("Kyung", "Koo Yoon", "TmaxSoft, Inc."));
        persons.add(new EGMember("Otavio", "Santana", "Individual Member"));
        persons.add(new EGMember("Rick", "Curtis", "IBM"));
        persons.add(new EGMember("Alexander", "Salvanos", "Individual Member"));
        persons.add(new EGMember("Romain", "Manni-Bucau", "Tomitribe"));

        return persons;
    }

    @POST
    @Path("all")
    public Response setAll(List<EGMember> persons) {
        for (EGMember person : persons) {
            System.out.println(person.toString());
        }
        return Response.accepted().build();
    }
}
