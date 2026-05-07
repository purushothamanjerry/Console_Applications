package org.example.railone.data.dto;

/**
 * DTO class representing a Notification
 */
public class Notification {
    private int notificationId;
    private int userId;
    private String notificationType; // Booking, Payment, Cancellation, Alert
    private String title;
    private String message;
    private String notificationDate;
    private boolean isRead;
    private String status; // Sent, Pending, Failed

    /**
     * Default constructor
     */
    public Notification() {
    }

    /**
     * Constructor with parameters
     */
    public Notification(int notificationId, int userId, String notificationType,
            String title, String message, String notificationDate,
            boolean isRead, String status) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.notificationType = notificationType;
        this.title = title;
        this.message = message;
        this.notificationDate = notificationDate;
        this.isRead = isRead;
        this.status = status;
    }

    // Getters and Setters
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", userId=" + userId +
                ", notificationType='" + notificationType + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", notificationDate='" + notificationDate + '\'' +
                ", isRead=" + isRead +
                ", status='" + status + '\'' +
                '}';
    }
}
