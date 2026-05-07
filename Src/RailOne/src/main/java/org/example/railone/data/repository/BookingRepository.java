package org.example.railone.data.repository;

import org.example.railone.data.dto.Booking;
import org.example.railone.data.dto.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for Booking data access
 * Manages in-memory storage of Booking objects and Tickets
 */
public class BookingRepository {
    private static List<Booking> bookings;
    private static List<Ticket> tickets;
    private static int bookingIdCounter = 1001;
    private static int ticketIdCounter = 5001;

    /**
     * Static initialization of bookings and tickets
     */
    static {
        bookings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    /**
     * Add a new booking
     */
    public static Booking addBooking(Booking booking) {
        booking.setBookingId(bookingIdCounter++);
        bookings.add(booking);
        return booking;
    }

    /**
     * Get all bookings
     */
    public static List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    /**
     * Find booking by bookingId
     */
    public static Booking findBookingById(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    /**
     * Find bookings by userId
     */
    public static List<Booking> findBookingsByUserId(int userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUserId() == userId) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    /**
     * Update booking
     */
    public static boolean updateBooking(Booking booking) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == booking.getBookingId()) {
                bookings.set(i, booking);
                return true;
            }
        }
        return false;
    }

    /**
     * Cancel booking
     */
    public static boolean cancelBooking(int bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.setStatus("Cancelled");
            booking.setPaymentStatus("Refunded");
            return true;
        }
        return false;
    }

    /**
     * Add a new ticket
     */
    public static Ticket addTicket(Ticket ticket) {
        ticket.setTicketId(ticketIdCounter++);
        tickets.add(ticket);
        return ticket;
    }

    /**
     * Get all tickets
     */
    public static List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    /**
     * Find ticket by ticketId
     */
    public static Ticket findTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Find tickets by bookingId
     */
    public static List<Ticket> findTicketsByBookingId(int bookingId) {
        List<Ticket> bookingTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getBookingId() == bookingId) {
                bookingTickets.add(ticket);
            }
        }
        return bookingTickets;
    }

    /**
     * Update ticket
     */
    public static boolean updateTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketId() == ticket.getTicketId()) {
                tickets.set(i, ticket);
                return true;
            }
        }
        return false;
    }

    /**
     * Cancel ticket
     */
    public static boolean cancelTicket(int ticketId) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            ticket.setStatus("Cancelled");
            return true;
        }
        return false;
    }

    /**
     * Get total bookings count
     */
    public static int getTotalBookingsCount() {
        return bookings.size();
    }

    /**
     * Get total revenue
     */
    public static double getTotalRevenue() {
        double revenue = 0;
        for (Booking booking : bookings) {
            if ("Confirmed".equals(booking.getStatus()) && "Paid".equals(booking.getPaymentStatus())) {
                revenue += booking.getTotalAmount();
            }
        }
        return revenue;
    }

    /**
     * Get bookings by status
     */
    public static List<Booking> getBookingsByStatus(String status) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getStatus().equals(status)) {
                result.add(booking);
            }
        }
        return result;
    }
}
