package org.example.railone.features.availabilitycheck;

import org.example.railone.data.dto.Train;
import org.example.railone.data.dto.Station;
import org.example.railone.data.repository.TrainRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Availability Check feature
 * Contains business logic for searching trains and checking seat availability
 */
public class AvailabilityModel {

    /**
     * Search trains by source and destination
     */
    public List<Train> searchTrains(int sourceStationId, int destinationStationId) {
        return TrainRepository.findTrainsByRoute(sourceStationId, destinationStationId);
    }

    /**
     * Get available trains with minimum seats
     */
    public List<Train> getAvailableTrains(int sourceStationId, int destinationStationId, int requiredSeats) {
        return TrainRepository.getTrainsWithAvailableSeats(sourceStationId, destinationStationId, requiredSeats);
    }

    /**
     * Get train details by ID
     */
    public Train getTrainDetails(int trainId) {
        return TrainRepository.findTrainById(trainId);
    }

    /**
     * Check if train has available seats
     */
    public boolean hasAvailableSeats(int trainId, int requiredSeats) {
        Train train = TrainRepository.findTrainById(trainId);
        return train != null && train.getAvailableSeats() >= requiredSeats;
    }

    /**
     * Get seat availability percentage
     */
    public double getSeatAvailabilityPercentage(int trainId) {
        Train train = TrainRepository.findTrainById(trainId);
        if (train == null) {
            return 0;
        }
        return ((double) train.getAvailableSeats() / train.getTotalSeats()) * 100;
    }

    /**
     * Get all stations
     */
    public List<Station> getAllStations() {
        return TrainRepository.getAllStations();
    }

    /**
     * Get station by ID
     */
    public Station getStation(int stationId) {
        return TrainRepository.findStationById(stationId);
    }

    /**
     * Get station by code
     */
    public Station getStationByCode(String code) {
        return TrainRepository.findStationByCode(code);
    }

    /**
     * Get all trains
     */
    public List<Train> getAllTrains() {
        return TrainRepository.getAllTrains();
    }
}
