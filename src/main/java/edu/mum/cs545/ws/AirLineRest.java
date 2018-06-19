package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

//import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Named
@Path("airline")
public class AirLineRest {

    @Inject
    private AirlineService airlineService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   postStudentRecord(Airline airline){

        airlineService.create(airline);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }



    @Path("/allAirLines")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAirLines() {
    	  JSONObject json = new JSONObject();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airlines", airlineService.findAll());
         return Response.ok(json.toString()).build();
    	
       
    }

}
