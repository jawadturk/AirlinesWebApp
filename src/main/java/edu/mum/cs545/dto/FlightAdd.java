package edu.mum.cs545.dto;

public class FlightAdd {

	    private String flightnr;
	    private String departureDate;
	    private String departureTime;
	    private String arrivalDate;
	    private String arrivalTime;
	    
	    private int departureAirportId;
	    private int destinationAirportId;
	    private int airlineId;
	    private int airplaneId;
	    
	    
		public String getFlightnr() {
			return flightnr;
		}
		public void setFlightnr(String flightnr) {
			this.flightnr = flightnr;
		}
		public String getDepartureDate() {
			return departureDate;
		}
		public void setDepartureDate(String departureDate) {
			this.departureDate = departureDate;
		}
		public String getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}
		public String getArrivalDate() {
			return arrivalDate;
		}
		public void setArrivalDate(String arrivalDate) {
			this.arrivalDate = arrivalDate;
		}
		public String getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public int getDepartureAirportId() {
			return departureAirportId;
		}
		public void setDepartureAirportId(int departureAirportId) {
			this.departureAirportId = departureAirportId;
		}
		public int getDestinationAirportId() {
			return destinationAirportId;
		}
		public void setDestinationAirportId(int destinationAirportId) {
			this.destinationAirportId = destinationAirportId;
		}
		public int getAirlineId() {
			return airlineId;
		}
		public void setAirlineId(int airlineId) {
			this.airlineId = airlineId;
		}
		public int getAirplaneId() {
			return airplaneId;
		}
		public void setAirplaneId(int airplaneId) {
			this.airplaneId = airplaneId;
		}
		@Override
		public String toString() {
			return "FlightAdd [flightnr=" + flightnr + ", departureDate=" + departureDate + ", departureTime="
					+ departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
					+ ", departureAirportId=" + departureAirportId + ", destinationAirportId=" + destinationAirportId
					+ ", airlineId=" + airlineId + ", airplaneId=" + airplaneId + "]";
		}
		
		
		
	
}
