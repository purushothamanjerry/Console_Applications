package org.example.railone.data.dto;

/**
 * DTO class representing a Ticket
 */
public class Ticket {
    private int ticketId;
    private int bookingId;
    private int seatNumber;
    private String passengerName;
    private String passengerAadhar;
    private String seatType; // AC, Non-AC, Sleeper, etc.
    private double ticketFare;
    private String status; // Confirmed, Cancelled, Pending

    /**
     * Default constructor
     */
    public Ticket() {
    }

    /**
     * Constructor with parameters
     */
    public Ticket(int ticketId, int bookingId, int seatNumber,
            String passengerName, String passengerAadhar,
            String seatType, double ticketFare, String status) {
        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
        this.passengerName = passengerName;
        this.passengerAadhar = passengerAadhar;
        this.seatType = seatType;
        this.ticketFare = ticketFare;
        this.status = status;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerAadhar() {
        return passengerAadhar;
    }

    public void setPassengerAadhar(String passengerAadhar) {
        this.passengerAadhar = passengerAadhar;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(double ticketFare) {
        this.ticketFare = ticketFare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", bookingId=" + bookingId +
                ", seatNumber=" + seatNumber +
                ", passengerName='" + passengerName + '\'' +
                ", seatType='" + seatType + '\'' +
                ", ticketFare=" + ticketFare +
                ", status='" + status + '\'' +
                '}';
    }
}
