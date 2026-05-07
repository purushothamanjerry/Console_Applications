package org.example.railone.features.payment;

import org.example.railone.data.dto.*;
import org.example.railone.data.repository.*;
import org.example.railone.util.DateUtil;

/**
 * Model class for Payment feature
 * Contains business logic for payment processing
 */
public class PaymentModel {

    /**
     * Process payment
     */
    public Payment processPayment(int bookingId, int userId, double amount, String paymentMethod) {
        // Create transaction ID
        String transactionId = generateTransactionId();

        // Simulate payment processing
        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setPaymentDate(DateUtil.getCurrentDateTime());
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionId(transactionId);

        // 95% success rate for simulation
        payment.setStatus(Math.random() > 0.05 ? "Success" : "Failed");

        // Save payment
        return PaymentRepository.addPayment(payment);
    }

    /**
     * Generate transaction ID
     */
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    /**
     * Get payment by ID
     */
    public Payment getPaymentById(int paymentId) {
        return PaymentRepository.findPaymentById(paymentId);
    }

    /**
     * Get payments by booking ID
     */
    public java.util.List<Payment> getPaymentsByBookingId(int bookingId) {
        return PaymentRepository.findPaymentsByBookingId(bookingId);
    }

    /**
     * Get payments by user ID
     */
    public java.util.List<Payment> getPaymentsByUserId(int userId) {
        return PaymentRepository.findPaymentsByUserId(userId);
    }

    /**
     * Check if payment successful
     */
    public boolean isPaymentSuccessful(int bookingId) {
        java.util.List<Payment> payments = getPaymentsByBookingId(bookingId);
        for (Payment payment : payments) {
            if ("Success".equals(payment.getStatus())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Update booking payment status
     */
    public void updateBookingPaymentStatus(int bookingId, String status) {
        Booking booking = BookingRepository.findBookingById(bookingId);
        if (booking != null) {
            booking.setPaymentStatus(status);
            BookingRepository.updateBooking(booking);
        }
    }

    /**
     * Get booking
     */
    public Booking getBooking(int bookingId) {
        return BookingRepository.findBookingById(bookingId);
    }

    /**
     * Refund payment
     */
    public boolean refundPayment(int bookingId) {
        java.util.List<Payment> payments = getPaymentsByBookingId(bookingId);
        for (Payment payment : payments) {
            if ("Success".equals(payment.getStatus())) {
                payment.setStatus("Refunded");
                PaymentRepository.updatePayment(payment);
                return true;
            }
        }
        return false;
    }
}
