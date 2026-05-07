package org.example.railone.data.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class representing a Booking
 */
public class Booking {
    private int bookingId;
    private int userId;
    private int trainId;
    private String bookingDate;
    private String journeyDate;
    private String status; // Confirmed, Cancelled, Pending
    private double totalAmount;
    private List<Ticket> tickets;
    private String paymentStatus; // Paid, Pending, Refunded

    /**
     * Default constructor
     */
    public Booking() {
        this.tickets = new ArrayList<>();
    }

    /**
     * Constructor with parameters
     */
    public Booking(int bookingId, int userId, int trainId,
            String bookingDate, String journeyDate, String status,
            double totalAmount, String paymentStatus) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.trainId = trainId;
        this.bookingDate = bookingDate;
        this.journeyDate = journeyDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.tickets = new ArrayList<>();
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * Add a ticket to this booking
     */
    public void addTicket(Ticket ticket) {
        if (this.tickets == null) {
            this.tickets = new ArrayList<>();
        }
        this.tickets.add(ticket);
    }

    /**
     * Get number of tickets in this booking
     */
    public int getTicketCount() {
        return tickets != null ? tickets.size() : 0;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", trainId=" + trainId +
                ", bookingDate='" + bookingDate + '\'' +
                ", journeyDate='" + journeyDate + '\'' +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", ticketCount=" + getTicketCount() +
                '}';
    }
}
