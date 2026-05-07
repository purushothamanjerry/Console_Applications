package org.example.railone.features.booking;

import org.example.railone.data.dto.*;
import org.example.railone.data.repository.*;
import org.example.railone.util.DateUtil;

import java.util.List;

/**
 * Model class for Booking feature
 * Contains business logic for booking tickets
 */
public class BookingModel {

    /**
     * Get booking by ID
     */
    public Booking getBooking(int bookingId) {
        return BookingRepository.findBookingById(bookingId);
    }

    /**
     * Get all bookings for a user
     */
    public List<Booking> getUserBookings(int userId) {
        return BookingRepository.findBookingsByUserId(userId);
    }

    /**
     * Get train details
     */
    public Train getTrainDetails(int trainId) {
        return TrainRepository.findTrainById(trainId);
    }

    /**
     * Create a booking
     */
    public Booking createBooking(int userId, int trainId, String journeyDate, int numPassengers) {
        // Validate train exists and has seats
        Train train = getTrainDetails(trainId);
        if (train == null || train.getAvailableSeats() < numPassengers) {
            return null;
        }

        // Create booking
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setTrainId(trainId);
        booking.setBookingDate(DateUtil.getCurrentDate());
        booking.setJourneyDate(journeyDate);
        booking.setStatus("Pending");
        booking.setPaymentStatus("Pending");
        booking.setTotalAmount(train.getBaseFare() * numPassengers);

        // Save booking
        return BookingRepository.addBooking(booking);
    }

    /**
     * Add ticket to booking
     */
    public Ticket addTicketToBooking(int bookingId, int seatNumber, String passengerName,
            String passengerAadhar, String seatType, double ticketFare) {
        Booking booking = getBooking(bookingId);
        if (booking == null) {
            return null;
        }

        Ticket ticket = new Ticket();
        ticket.setBookingId(bookingId);
        ticket.setSeatNumber(seatNumber);
        ticket.setPassengerName(passengerName);
        ticket.setPassengerAadhar(passengerAadhar);
        ticket.setSeatType(seatType);
        ticket.setTicketFare(ticketFare);
        ticket.setStatus("Pending");

        // Save ticket
        Ticket savedTicket = BookingRepository.addTicket(ticket);
        booking.addTicket(savedTicket);

        return savedTicket;
    }

    /**
     * Confirm booking
     */
    public boolean confirmBooking(int bookingId, int trainId) {
        Booking booking = getBooking(bookingId);
        Train train = getTrainDetails(trainId);

        if (booking == null || train == null) {
            return false;
        }

        int numTickets = booking.getTicketCount();
        if (train.getAvailableSeats() < numTickets) {
            return false;
        }

        // Update booking status
        booking.setStatus("Confirmed");
        booking.setPaymentStatus("Pending");

        // Update train available seats
        train.setAvailableSeats(train.getAvailableSeats() - numTickets);

        // Update all tickets status
        for (Ticket ticket : booking.getTickets()) {
            ticket.setStatus("Confirmed");
            BookingRepository.updateTicket(ticket);
        }

        // Save updates
        BookingRepository.updateBooking(booking);
        TrainRepository.updateTrain(train);

        return true;
    }

    /**
     * Get all bookings
     */
    public List<Booking> getAllBookings() {
        return BookingRepository.getAllBookings();
    }

    /**
     * Get stations
     */
    public Station getStation(int stationId) {
        return TrainRepository.findStationById(stationId);
    }

    /**
     * Get user
     */
    public User getUser(int userId) {
        return UserRepository.findById(userId);
    }
}
