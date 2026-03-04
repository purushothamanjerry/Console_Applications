package Railway2;
import java.util.*;

public class Seat {

    private final int MAX_LOWER = 1;
    private final int MAX_MIDDLE = 1;
    private final int MAX_UPPER = 1;
    private final int MAX_RAC = 2;
    private final int MAX_WL = 1;

    private List<Passenger> upperList = new ArrayList<>();
    private List<Passenger> middleList = new ArrayList<>();
    private List<Passenger> lowerList = new ArrayList<>();

    private Queue<Passenger> racQueue = new LinkedList<>();
    private Queue<Passenger> waitinglist = new LinkedList<>();

    public boolean lowerAvailable() { return lowerList.size() < MAX_LOWER; }
    public boolean middleAvailable() { return middleList.size() < MAX_MIDDLE; }
    public boolean upperAvailable() { return upperList.size() < MAX_UPPER; }

    public boolean cnfAvailable() {
        return lowerAvailable() || middleAvailable() || upperAvailable();
    }

    public boolean racAvailable() {
        return racQueue.size() < MAX_RAC;
    }

    public boolean wlAvailable() {
        return waitinglist.size() < MAX_WL;
    }

    @Override
    public String toString() {
        return "Lower Available: " + (MAX_LOWER - lowerList.size()) +
               ", Middle Available: " + (MAX_MIDDLE - middleList.size()) +
               ", Upper Available: " + (MAX_UPPER - upperList.size()) +
               ", RAC Available: " + (MAX_RAC - racQueue.size()) +
               ", WL Available: " + (MAX_WL - waitinglist.size());
    }
    public List<Passenger> getUpperList() {
        return upperList;
    }

    public List<Passenger> getMiddleList() {
        return middleList;
    }

    public List<Passenger> getLowerList() {
        return lowerList;
    }

    public Queue<Passenger> getRacQueue() {
        return racQueue;
    }

    public Queue<Passenger> getWaitinglist() {
        return waitinglist;
    }

}



