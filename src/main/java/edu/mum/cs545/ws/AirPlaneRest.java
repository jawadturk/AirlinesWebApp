package edu.mum.cs545.ws;

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

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
@Path("airPlane")
public class AirPlaneRest {

    @Inject
    private AirplaneService airPlaneService;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response   createAirPlane(Airplane airPlane){

    	airPlaneService.create(airPlane);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }



    @Path("allAirPlanes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAirLines() {
    	  JSONObject json = new JSONObject();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airPlanes", airPlaneService.findAll());
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response  deleteAirPlane(Airplane airPlane){

    	airPlaneService.delete(airPlane);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAirplane(Airplane airPlane){

    	airPlaneService.update(airPlane);
        JSONObject json = new JSONObject();

        json.put("status", "success");
        json.put("code", Response.Status.OK.getStatusCode());
        return Response.ok(json.toString()).build();

    }
    
    @Path("/find")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findSpecificAirplane(Airplane airPlane) {
    	  JSONObject json = new JSONObject();
          Gson gson = new Gson();

         
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
		 json.put("airPlanes", gson.toJson(airPlaneService.find(airPlane)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/findBySrlnr/{serialNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirplaneBySerialNumber(@PathParam("serialNumber") String serialNumber ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airPlanes",gson.toJson( airPlaneService.findBySrlnr(serialNumber)));
         return Response.ok(json.toString()).build();
    	
       
    }
    
    @Path("/findByModel/{model}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirplaneByModel(@PathParam("model") String model ) {
    	  JSONObject json = new JSONObject();
    	  Gson gson = new Gson();
    	 json.put("status", "success");
         json.put("code", Response.Status.OK.getStatusCode());
         json.put("airPlanes",gson.toJson( airPlaneService.findByModel(model)));
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
		 json.put("airlines", gson.toJson(airPlaneService.findByFlight(flight)));
		
         return Response.ok(json.toString()).build();
    	
       
    }
}
