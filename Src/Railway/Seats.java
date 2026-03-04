package Railway;
import java.util.*;
public class Seats {
	private List<Passanger>ac;
	private Queue<Passanger>acW;
	private List<Passanger>nonAc;
	private Queue<Passanger>nonAcW;
	private List<Passanger>seater;
	private Queue<Passanger>seaterW;
	public Seats() {
		ac=new ArrayList<>();
		nonAc=new ArrayList<>();
		seater=new ArrayList<>();
		acW=new LinkedList<>();
		nonAcW=new LinkedList<>();
		seaterW=new LinkedList<>();
	}
	public List<Passanger> getAc() {
		return ac;
	}
	public void setAc(List<Passanger> ac) {
		this.ac = ac;
	}
	public Queue<Passanger> getAcW() {
		return acW;
	}
	public void setAcW(Queue<Passanger> acW) {
		this.acW = acW;
	}
	public List<Passanger> getNonAc() {
		return nonAc;
	}
	public void setNonAc(List<Passanger> nonAc) {
		this.nonAc = nonAc;
	}
	public Queue<Passanger> getNonAcW() {
		return nonAcW;
	}
	public void setNonAcW(Queue<Passanger> nonAcW) {
		this.nonAcW = nonAcW;
	}
	public List<Passanger> getSeater() {
		return seater;
	}
	public void setSeater(List<Passanger> seater) {
		this.seater = seater;
	}
	public Queue<Passanger> getSeaterW() {
		return seaterW;
	}
	public void setSeaterW(Queue<Passanger> seaterW) {
		this.seaterW = seaterW;
	}
	
}
