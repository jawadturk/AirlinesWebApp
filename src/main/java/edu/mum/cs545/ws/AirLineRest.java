package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;
import edu.mum.cs545.dto.AirlineCreationRequest;
import edu.mum.cs545.dto.FlightCreationDetail;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

//import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Named
@Path("airline")
public class AirLineRest {
	 ObjectMapper mapper = new ObjectMapper();

	 @Inject
	    private FlightService flightService;

	    @Inject
	    private AirlineService airlineService;
	    
	    @Inject
	    private AirportService airportService;
	    
	    @Inject
	    private AirplaneService airPlaneService;
	    
	@Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(AirlineCreationRequest airlineReq) {
		 JSONObject json = new JSONObject();
		try {
            Airline airlineObj = new Airline();
            airlineObj.setName(airlineReq.getAirlineName());

            for(FlightCreationDetail airline : airlineReq.getFlightCreationDetails()){
                Airport origin = airportService.findByName(airline.getOriginName()).get(0);
                Airport destination = airportService.findByName(airline.getDestinationName()).get(0);

                Airplane airplane = airPlaneService.findBySrlnr(airline.getSerialNumberAirPlane());

                Flight flight = new Flight();
                flight.setArrivalDate(airline.getArrivalDate());
                flight.setArrivalTime(airline.getArrivalTime());
                flight.setDepartureDate(airline.getDepartureDate());
                flight.setDepartureTime(airline.getDepartureTime());

                flight.setFlightnr(airline.getFlightnr());
                flight.setOrigin(origin);
                flight.setDestination(destination);

                flight.setAirplane(airplane);
                airlineObj.addFlight(flight);
            }

            airlineService.create(airlineObj);
        } catch (Exception ex) {
          json.put("error", ex.toString());
        }
       

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
        
         try {
 			json.put("airlines",mapper.writeValueAsString(airlineService.findAll()) );
 		} catch (JSONException | JsonProcessingException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			 json.put("error", e.toString());
 		}
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response   deleteAirLine(@PathParam("id") long id){
    	Airline airline= new Airline();
    	airline.setId(id);

    	System.out.print(id);
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
    
    @Path("/getAirLine/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSpecificAirLine(@PathParam("id") long id) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          Airline airline= new Airline();
      	  airline.setId(id);
         
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
