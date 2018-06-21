package edu.mum.cs545.ws;


import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;
import edu.mum.cs545.dto.FlightAdd;
import edu.mum.cs545.dto.FlightCreationRequest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;

//import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Named
@Path("flight")
public class FlightRest {
    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
    @Inject
    private FlightService flightService;

    @Inject
    private AirlineService airlineService;
    
    @Inject
    private AirportService airportService;
    
    @Inject
    private AirplaneService airPlaneService;
    

    

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
    
    @Path("/deleteAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAll() {
    	 
    	flightService.deleteAll();
    	
       
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
    
    @Path("findByArrival/{arrivalDate}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByArrival(@PathParam("arrivalDate") String arrivalDate) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

          Date date;
		try {
			date = df.parse(arrivalDate.toString().replace("-", "/"));
			 json.put("flights", flightService.findByArrival(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		
		
         return Response.ok(json.toString()).build();
    }
    
    
    @Path("findByDeparture/{departureDate}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByDeparture(@PathParam("departureDate") String departureDate){
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          Date date;
  		try {
  			date = df.parse(departureDate.toString().replace("-", "/"));
  			 json.put("flights", flightService.findByDeparture(date));
  		} catch (ParseException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		
		
         return Response.ok(json.toString()).build();
    }
    
    @Path("/findByArrivalBetween")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByArrivalBetween(@QueryParam("datetimeFromPara") Date datetimeFromPara, @QueryParam("datetimeToPara") Date datetimeToPara){
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

        
		try {
			Date datetimeFrom = df.parse(datetimeFromPara.toString().replace("-", "/"));
			Date datetimeTo = df.parse(datetimeToPara.toString().replace("-", "/"));
			json.put("flights", flightService.findByArrivalBetween(datetimeFrom, datetimeTo));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());

		
         return Response.ok(json.toString()).build();
    }
    
    
    @Path("/findByDepartureBetween")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByDepartureBetween(@QueryParam("datetimeFromPara") Date datetimeFromPara, @QueryParam("datetimeToPara") Date datetimeToPara){
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();
          try {
  			Date datetimeFrom = df.parse(datetimeFromPara.toString().replace("-", "/"));
  			Date datetimeTo = df.parse(datetimeToPara.toString().replace("-", "/"));
  			 json.put("flights", flightService.findByDepartureBetween( datetimeFrom,  datetimeTo));
  		} catch (ParseException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
            
         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		
		
         return Response.ok(json.toString()).build();
    }
    
}
