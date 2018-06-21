package edu.mum.cs545.dto;

import java.util.ArrayList;
import java.util.List;

public class FlightCreationRequest {
	
	private List<FlightAdd> flights ;

	public List<FlightAdd> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightAdd> flights) {
		this.flights = flights;
	}

}
