package org.example.railone.data.repository;

import org.example.railone.data.dto.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for Payment data access
 * Manages in-memory storage of Payment objects
 */
public class PaymentRepository {
    private static List<Payment> payments;
    private static int paymentIdCounter = 10001;

    /**
     * Static initialization of payments
     */
    static {
        payments = new ArrayList<>();
    }

    /**
     * Add a new payment
     */
    public static Payment addPayment(Payment payment) {
        payment.setPaymentId(paymentIdCounter++);
        payments.add(payment);
        return payment;
    }

    /**
     * Get all payments
     */
    public static List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    /**
     * Find payment by paymentId
     */
    public static Payment findPaymentById(int paymentId) {
        for (Payment payment : payments) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    /**
     * Find payments by bookingId
     */
    public static List<Payment> findPaymentsByBookingId(int bookingId) {
        List<Payment> bookingPayments = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getBookingId() == bookingId) {
                bookingPayments.add(payment);
            }
        }
        return bookingPayments;
    }

    /**
     * Find payments by userId
     */
    public static List<Payment> findPaymentsByUserId(int userId) {
        List<Payment> userPayments = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getUserId() == userId) {
                userPayments.add(payment);
            }
        }
        return userPayments;
    }

    /**
     * Find payment by transaction Id
     */
    public static Payment findPaymentByTransactionId(String transactionId) {
        for (Payment payment : payments) {
            if (payment.getTransactionId().equals(transactionId)) {
                return payment;
            }
        }
        return null;
    }

    /**
     * Update payment
     */
    public static boolean updatePayment(Payment payment) {
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getPaymentId() == payment.getPaymentId()) {
                payments.set(i, payment);
                return true;
            }
        }
        return false;
    }

    /**
     * Get payments by status
     */
    public static List<Payment> getPaymentsByStatus(String status) {
        List<Payment> result = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getStatus().equals(status)) {
                result.add(payment);
            }
        }
        return result;
    }

    /**
     * Get total payment amount
     */
    public static double getTotalPaymentAmount() {
        double total = 0;
        for (Payment payment : payments) {
            if ("Success".equals(payment.getStatus())) {
                total += payment.getAmount();
            }
        }
        return total;
    }

    /**
     * Get total successful payments count
     */
    public static int getTotalSuccessfulPayments() {
        int count = 0;
        for (Payment payment : payments) {
            if ("Success".equals(payment.getStatus())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get payment statistics by method
     */
    public static int getPaymentCountByMethod(String method) {
        int count = 0;
        for (Payment payment : payments) {
            if (payment.getPaymentMethod().equals(method) && "Success".equals(payment.getStatus())) {
                count++;
            }
        }
        return count;
    }
}
