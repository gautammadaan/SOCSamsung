package soc.samsung.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import soc.samsung.dto.*;
import soc.samsung.po.serviceTrustPO;

@Path("/")
public class mobileService {
	
	public List<Point> verifyPoints;
	public List<String> streetNames;
	public List<serviceTrustPO> serviceTrust;
	
	public mobileService() {
		// TODO Auto-generated constructor stub
		verifyPoints = new ArrayList<Point>();
		streetNames = new ArrayList<String>();
		serviceTrust = new ArrayList<serviceTrustPO>();		
	}
	

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/register")
    public Behavior registerStreet(StreetRegistration street) {
        Behavior behavior = new Behavior();
        behavior.setBehavior("sample");
        return behavior;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/recommendation")
    public Recommendation recommendation(Point segment) {
        Recommendation recommend = new Recommendation();
        recommend.setRecommendedURI("http://recommended");
        return recommend;
    }

    @POST
    @Consumes("application/json")
    @Path("/evaluation_start")
    public Response evaluationStart(Point segment) {
        return ok();
    }

    @POST
    @Consumes("application/json")
    @Path("/evaluate")
    public Response evaluate(Evaluation evaluation) {
        return ok();
    }

    @POST
    @Consumes("application/json")
    @Path("/streetsample")
    public Response submitPoint(StreetSample sample) {
        return ok();
    }

    protected Response ok(Object obj) {
        return Response.status(Status.OK).entity(obj).build();
    }

    protected Response ok() {
        return Response.status(Status.OK).build();
    }
}
