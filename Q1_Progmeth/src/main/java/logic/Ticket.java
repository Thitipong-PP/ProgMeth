package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
		if (type == 0) {
			this.type = type;
			this.priceperstation = 30;
		}else if (type == 2) {
			this.type = type;
			this.priceperstation = 25;
		}else {
			this.type = 1;
			this.priceperstation = 30;
		}
	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
		// check Valid
		if (!isStationValid(this.start, this.end)) return -1;
		if (this.start == this.end) return -1;
		if (this.type == 2 && getStationDistance(this.start, this.end) > 6) return -1;

		double result = this.priceperstation * getStationDistance(this.start, this.end);
		if (this.type == 0 && this.getStationDistance(this.start, this.end) > 4) result = result * 80.0/100.0;
		else if (this.type == 2) result = result * 60.0/100.0;

		return result;
	}
	
	public String getDescription() {
		String typename;
		
		switch(this.getType()) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			//FILL CODE
			typename = "Adult";
			break;
		case 2:
			//FILL CODE
			typename = "Elderly";
			break;
		default:
			typename = "Invalid";
			break;
		}

		if (this.getType() == 2 && this.getStationDistance(this.start, this.end) > 6) typename = "Invalid";
		
		return typename+" Ticket, from "+ this.start.getName() +" to "+ this.end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
