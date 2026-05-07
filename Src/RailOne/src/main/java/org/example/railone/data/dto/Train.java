package org.example.railone.data.dto;

/**
 * DTO class representing a Train
 */
public class Train {
    private int trainId;
    private String trainName;
    private String trainNumber;
    private int sourceStationId;
    private int destinationStationId;
    private String departureTime;
    private String arrivalTime;
    private double baseFare;
    private int totalSeats;
    private int availableSeats;
    private String trainType; // Express, Local, AC, Non-AC

    /**
     * Default constructor
     */
    public Train() {
    }

    /**
     * Constructor with parameters
     */
    public Train(int trainId, String trainName, String trainNumber,
            int sourceStationId, int destinationStationId,
            String departureTime, String arrivalTime,
            double baseFare, int totalSeats, String trainType) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.baseFare = baseFare;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially all seats are available
        this.trainType = trainType;
    }

    // Getters and Setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getSourceStationId() {
        return sourceStationId;
    }

    public void setSourceStationId(int sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public int getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(int destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", trainName='" + trainName + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", baseFare=" + baseFare +
                ", availableSeats=" + availableSeats +
                ", trainType='" + trainType + '\'' +
                '}';
    }
}
