package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
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
@Path("airport")
public class AirportRest {

    @Inject
    private AirportService airportService;
  

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   createAirport(Airport airport){

    	airportService.create(airport);
      
    	
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }



    @Path("/allAirports")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAirports() {
    	  JSONObject json = new JSONObject();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airports", airportService.findAll());
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response   deleteAirport(@PathParam("id") long id){

    	Airport airport= new Airport();
    	airport.setId(id);
    	airportService.delete(airport);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   updateAirport(Airport airport){

    	airportService.update(airport);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @Path("/getAirport/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   
    public Response getSpecificAirLine(@PathParam("id") long id) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          Airport airport= new Airport();
      	  airport.setId(id);
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airports", gson.toJson(airportService.find(airport)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/findByCode/{airportcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificAirLine(@PathParam("airportcode") String airportcode ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airports",gson.toJson( airportService.findByCode(airportcode)));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByArrival/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response findByArrival(@PathParam("id") long id) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          Flight flight = new Flight();
          flight.setId(id);
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airports",airportService.findByArrival(flight));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByDeparture/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   
    public Response findByDeparture(@PathParam("id") long id) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          Flight flight = new Flight();
          flight.setId(id);
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airports",airportService.findByDeparture(flight));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByCity/{city}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCity(@PathParam("city") String city ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airports",airportService.findByCity(city));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/findByCountry/{country}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCountry(@PathParam("country") String country ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airports",airportService.findByCountry(country));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airports",airportService.findByName(name));
         return Response.ok(json.toString()).build();
    	
       
    }
}
