package org.example.railone.features.cancelticket;

import org.example.railone.data.dto.*;
import org.example.railone.data.repository.*;
import org.example.railone.util.Constants;

/**
 * Model class for Cancel Ticket feature
 * Contains business logic for ticket cancellation
 */
public class CancelTicketModel {

    /**
     * Get booking by ID
     */
    public Booking getBooking(int bookingId) {
        return BookingRepository.findBookingById(bookingId);
    }

    /**
     * Get tickets by booking ID
     */
    public java.util.List<Ticket> getBookingTickets(int bookingId) {
        return BookingRepository.findTicketsByBookingId(bookingId);
    }

    /**
     * Cancel booking and refund
     */
    public boolean cancelBooking(int bookingId, int trainId) {
        Booking booking = getBooking(bookingId);
        Train train = TrainRepository.findTrainById(trainId);

        if (booking == null || train == null) {
            return false;
        }

        if (!booking.getStatus().equals("Confirmed")) {
            return false; // Can only cancel confirmed bookings
        }

        // Cancel all tickets in the booking
        java.util.List<Ticket> tickets = getBookingTickets(bookingId);
        for (Ticket ticket : tickets) {
            if (!ticket.getStatus().equals("Cancelled")) {
                ticket.setStatus("Cancelled");
                BookingRepository.updateTicket(ticket);
            }
        }

        // Update booking status
        booking.setStatus("Cancelled");
        booking.setPaymentStatus("Refunded");
        BookingRepository.updateBooking(booking);

        // Free up seats in train
        train.setAvailableSeats(train.getAvailableSeats() + tickets.size());
        TrainRepository.updateTrain(train);

        return true;
    }

    /**
     * Get refund amount
     */
    public double calculateRefundAmount(Booking booking) {
        double refundPercentage = Constants.CANCELLATION_REFUND_PERCENTAGE;
        return (booking.getTotalAmount() * refundPercentage) / 100;
    }

    /**
     * Get user bookings
     */
    public java.util.List<Booking> getUserBookings(int userId) {
        return BookingRepository.findBookingsByUserId(userId);
    }

    /**
     * Get train details
     */
    public Train getTrainDetails(int trainId) {
        return TrainRepository.findTrainById(trainId);
    }

    /**
     * Get station details
     */
    public Station getStation(int stationId) {
        return TrainRepository.findStationById(stationId);
    }

    /**
     * Check if booking can be cancelled
     */
    public boolean canCancelBooking(Booking booking) {
        return booking != null &&
                "Confirmed".equals(booking.getStatus()) &&
                !"Cancelled".equals(booking.getStatus());
    }
}
