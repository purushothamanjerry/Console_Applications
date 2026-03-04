package Railway;
import java.util.*;
public class Train {
	
	private int num;
	private List<String>stops;
	private Seats seats;
	public Train() {
	}
	public Train(int num,String arr[]) {
		super();
		this.num = num;
		this.stops = new ArrayList<>(Arrays.asList(arr));
		seats=new Seats();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<String> getStops() {
		return stops;
	}
	public void setStops(List<String> stops) {
		this.stops = stops;
	}
	public Seats getSeats() {
		return seats;
	}
	public void setSeats(Seats seats) {
		this.seats = seats;
	}
	
}
