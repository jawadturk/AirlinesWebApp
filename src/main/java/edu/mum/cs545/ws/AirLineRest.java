package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;

//import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Named
@Path("airline")
public class AirLineRest {

    @Inject
    private AirlineService airlineService;
    
    @Inject
    private FlightService flightService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   postAirLine(Airline airline){

        airlineService.create(airline);
        for(int i=0;i<airline.getFlights().size();i++)
    	{
        	System.out.print("flighttest"+airline.getFlights().get(i).toString());
    		flightService.create(airline.getFlights().get(i));	
    	}
    	
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
    
    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   deleteAirLine(Airline airline){

        airlineService.delete(airline);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   updateAirLine(Airline airline){

        airlineService.update(airline);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @Path("/getAirLine")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSpecificAirLine(Airline airline) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airlines", gson.toJson(airlineService.find(airline)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/getByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificAirLine(@PathParam("name") String name ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airlines",gson.toJson( airlineService.findByName(name)));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByFlight")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getByFlight(Flight flight) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airlines", gson.toJson(airlineService.findByFlight(flight)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
}
