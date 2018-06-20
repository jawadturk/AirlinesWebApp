package edu.mum.cs545.ws;


import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
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
import java.util.Date;
import java.util.List;

@Named
@Path("flight")
public class FlightRest {

    @Inject
    private FlightService flightService;


    @Path("/allFlights")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlights() {
    	  JSONObject json = new JSONObject();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("flights", flightService.findAll());
         return Response.ok(json.toString()).build();
    	
       
    }
    
  
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   updateAirLine(Flight flight){

    	flightService.update(flight);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @Path("/getFlight")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSpecificFlight(Flight flight) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("flights", gson.toJson(flightService.find(flight)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/getByNumber/{flightnr}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificFlightByNumber(@PathParam("flightnr") String flightnr ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("flights", flightService.findByNumber(flightnr));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/findByAirline")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getFlightByAirLine(Airline airLine) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("flights", flightService.findByAirline(airLine));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    
    @Path("/findByOrigin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getFlightByAirportOrigin(Airport airport) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("flights", flightService.findByOrigin(airport));
		
         return Response.ok(json.toString()).build();
    }
    
  
    @Path("/findByDestination")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getFlightByAirportDestination(Airport airport) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("flights", flightService.findByDestination(airport));
		
         return Response.ok(json.toString()).build();
    }
    
    
    @Path("/findByAirplane")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getFlightByAirplane(Airplane airplane) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("flights", flightService.findByAirplane(airplane));
		
         return Response.ok(json.toString()).build();
    }
    
//    @Path("/findByArrival")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response findByArrival(Date datetime) {
//    	  JSONObject json = new JSONObject();
//          Gson gson = new Gson();
//
//         
//    	 json.put("status", "success");
//         json.put("code", Response.Status.OK.getStatusCode());
//		 json.put("flights", flightService.findByArrival(datetime));
//		
//         return Response.ok(json.toString()).build();
//    }
//    
//    
//    @Path("/findByDeparture")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response findByDeparture(Date datetime){
//    	  JSONObject json = new JSONObject();
//          Gson gson = new Gson();
//
//         
//    	 json.put("status", "success");
//         json.put("code", Response.Status.OK.getStatusCode());
//		 json.put("flights", flightService.findByDeparture(datetime));
//		
//         return Response.ok(json.toString()).build();
//    }
//    
//    @Path("/findByArrivalBetween")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response findByArrivalBetween(Date datetimeFrom, Date datetimeTo){
//    	  JSONObject json = new JSONObject();
//          Gson gson = new Gson();
//
//         
//    	 json.put("status", "success");
//         json.put("code", Response.Status.OK.getStatusCode());
//		 json.put("flights", flightService.findByArrivalBetween(datetimeFrom, datetimeTo));
//		
//         return Response.ok(json.toString()).build();
//    }
//    
//    
//    @Path("/findByDepartureBetween")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response findByDepartureBetween(Date datetimeFrom, Date datetimeTo){
//    	  JSONObject json = new JSONObject();
//          Gson gson = new Gson();
//
//         
//    	 json.put("status", "success");
//         json.put("code", Response.Status.OK.getStatusCode());
//		 json.put("flights", flightService.findByDepartureBetween( datetimeFrom,  datetimeTo));
//		
//         return Response.ok(json.toString()).build();
//    }
    
}
