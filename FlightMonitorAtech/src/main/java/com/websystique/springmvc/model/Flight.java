package com.websystique.springmvc.model;

public class Flight {

	private long id;
	
	private String departDate;
	
	private String returnDate;
	
	private String origin;
	
	private String destination;
	
	private String airplane;
	
	private String pilot;
	
	private String status;
	
	public Flight(long id, String departDate, String returnDate, String origin, String destination, String airplane,
			String pilot, String status) {
		super();
		this.id = id;
		this.departDate = departDate;
		this.returnDate = returnDate;
		this.origin = origin;
		this.destination = destination;
		this.airplane = airplane;
		this.pilot = pilot;
		this.status = status;
	}

	public Flight(){
		id=0;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Flight))
			return false;
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departDate=" + departDate + ", returnDate=" + returnDate + ", origin=" + origin
				+ ", destination=" + destination + ", airplane=" + airplane + ", pilot=" + pilot + ", status=" + status
				+ "]";
	}
}
