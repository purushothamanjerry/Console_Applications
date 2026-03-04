package Railway2;
import java.util.*;
public class Train {

    private final int trainnum;
    private final List<String> stops;
    private final Seat seat;

    public Train(int trainnum, List<String> stops) {
        this.trainnum = trainnum;
        this.stops = new ArrayList<>(stops);
        this.seat = new Seat();
    }

    public int getTrainnum() {
        return trainnum;
    }

    public List<String> getStops() {
        return Collections.unmodifiableList(stops);
    }

    public Seat getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Train No: " + trainnum + ", Stops: " + stops;
    }
}

