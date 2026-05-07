package org.example.railone.data.repository;

import org.example.railone.data.dto.Train;
import org.example.railone.data.dto.Station;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for Train data access
 * Manages in-memory storage of Train objects and Stations
 */
public class TrainRepository {
    private static List<Train> trains;
    private static List<Station> stations;
    private static int trainIdCounter = 1;
    private static int stationIdCounter = 1;

    /**
     * Static initialization of trains and stations
     */
    static {
        trains = new ArrayList<>();
        stations = new ArrayList<>();
        initializeSampleStations();
        initializeSampleTrains();
    }

    /**
     * Initialize sample stations
     */
    private static void initializeSampleStations() {
        stations.add(new Station(stationIdCounter++, "NDLS", "New Delhi Railway Station", "New Delhi", "Delhi"));
        stations.add(new Station(stationIdCounter++, "BRC", "Vadodara Junction", "Vadodara", "Gujarat"));
        stations.add(new Station(stationIdCounter++, "ADI", "Ahmedabad Junction", "Ahmedabad", "Gujarat"));
        stations.add(new Station(stationIdCounter++, "SURAT", "Surat Railway Station", "Surat", "Gujarat"));
        stations.add(new Station(stationIdCounter++, "BCT", "Mumbai Central", "Mumbai", "Maharashtra"));
        stations.add(new Station(stationIdCounter++, "PUNE", "Pune Junction", "Pune", "Maharashtra"));
        stations.add(new Station(stationIdCounter++, "BZA", "Vijayawada Junction", "Vijayawada", "Andhra Pradesh"));
        stations.add(new Station(stationIdCounter++, "HYB", "Hyderabad Deccan", "Hyderabad", "Telangana"));
    }

    /**
     * Initialize sample trains
     */
    private static void initializeSampleTrains() {
        // Train from Delhi to Mumbai
        trains.add(new Train(trainIdCounter++, "Rajdhani Express", "12001", 1, 5,
                "22:00", "08:00", 2500, 500, "AC"));

        // Train from Delhi to Ahmedabad
        trains.add(new Train(trainIdCounter++, "Gujarat Express", "12009", 1, 3,
                "20:30", "12:00", 1800, 400, "Non-AC"));

        // Train from Ahmedabad to Mumbai
        trains.add(new Train(trainIdCounter++, "Shatabdi Express", "12001", 3, 5,
                "07:00", "11:00", 1500, 300, "AC"));

        // Train from Mumbai to Pune
        trains.add(new Train(trainIdCounter++, "Deccan Queen", "12002", 5, 6,
                "07:10", "09:50", 800, 200, "AC"));

        // Train from Pune to Hyderabad
        trains.add(new Train(trainIdCounter++, "Hyderabad Express", "12725", 6, 8,
                "22:00", "08:10", 1200, 350, "Sleeper"));

        // Train from Ahmedabad to Surat
        trains.add(new Train(trainIdCounter++, "Surat Local", "12621", 3, 4,
                "10:00", "13:00", 600, 250, "Local"));

        // Train from New Delhi to Hyderabad
        trains.add(new Train(trainIdCounter++, "Flying Ranee", "12701", 1, 8,
                "15:50", "05:20", 2200, 450, "AC"));
    }

    /**
     * Add a new train
     */
    public static Train addTrain(Train train) {
        train.setTrainId(trainIdCounter++);
        trains.add(train);
        return train;
    }

    /**
     * Get all trains
     */
    public static List<Train> getAllTrains() {
        return new ArrayList<>(trains);
    }

    /**
     * Find train by trainId
     */
    public static Train findTrainById(int trainId) {
        for (Train train : trains) {
            if (train.getTrainId() == trainId) {
                return train;
            }
        }
        return null;
    }

    /**
     * Find train by train number
     */
    public static Train findTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }

    /**
     * Find trains by source and destination stations
     */
    public static List<Train> findTrainsByRoute(int sourceStationId, int destinationStationId) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getSourceStationId() == sourceStationId &&
                    train.getDestinationStationId() == destinationStationId) {
                result.add(train);
            }
        }
        return result;
    }

    /**
     * Update train
     */
    public static boolean updateTrain(Train train) {
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getTrainId() == train.getTrainId()) {
                trains.set(i, train);
                return true;
            }
        }
        return false;
    }

    /**
     * Get all stations
     */
    public static List<Station> getAllStations() {
        return new ArrayList<>(stations);
    }

    /**
     * Find station by stationId
     */
    public static Station findStationById(int stationId) {
        for (Station station : stations) {
            if (station.getStationId() == stationId) {
                return station;
            }
        }
        return null;
    }

    /**
     * Find station by station code
     */
    public static Station findStationByCode(String code) {
        for (Station station : stations) {
            if (station.getStationCode().equalsIgnoreCase(code)) {
                return station;
            }
        }
        return null;
    }

    /**
     * Add a new station
     */
    public static Station addStation(Station station) {
        station.setStationId(stationIdCounter++);
        stations.add(station);
        return station;
    }

    /**
     * Get trains with available seats
     */
    public static List<Train> getTrainsWithAvailableSeats(int sourceStationId,
            int destinationStationId,
            int requiredSeats) {
        List<Train> availableTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getSourceStationId() == sourceStationId &&
                    train.getDestinationStationId() == destinationStationId &&
                    train.getAvailableSeats() >= requiredSeats) {
                availableTrains.add(train);
            }
        }
        return availableTrains;
    }
}
