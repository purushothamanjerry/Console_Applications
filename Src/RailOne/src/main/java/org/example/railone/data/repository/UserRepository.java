package org.example.railone.data.repository;

import org.example.railone.data.dto.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for User data access
 * Manages in-memory storage of User objects
 */
public class UserRepository {
    private static List<User> users;
    private static int userIdCounter = 1;

    /**
     * Static initialization of users list
     */
    static {
        users = new ArrayList<>();
        initializeSampleUsers();
    }

    /**
     * Initialize sample users for testing
     */
    private static void initializeSampleUsers() {
        // Admin user
        User admin = new User(userIdCounter++, "Admin", "User", "admin@railone.com",
                "9876543210", "admin", "admin123",
                "123456789012", true, "2024-01-01");
        users.add(admin);

        // Sample regular users
        User user1 = new User(userIdCounter++, "Rajesh", "Kumar", "rajesh@email.com",
                "9876543211", "rajesh", "pass123",
                "111111111111", false, "2024-01-15");
        users.add(user1);

        User user2 = new User(userIdCounter++, "Priya", "Singh", "priya@email.com",
                "9876543212", "priya", "pass123",
                "222222222222", false, "2024-02-01");
        users.add(user2);
    }

    /**
     * Add a new user to the repository
     */
    public static User addUser(User user) {
        user.setUserId(userIdCounter++);
        users.add(user);
        return user;
    }

    /**
     * Find user by username
     */
    public static User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Find user by email
     */
    public static User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Find user by userId
     */
    public static User findById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     * Find user by Aadhar number
     */
    public static User findByAadhar(String aadharNumber) {
        for (User user : users) {
            if (user.getAadharNumber().equals(aadharNumber)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get all users
     */
    public static List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Update user
     */
    public static boolean updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == user.getUserId()) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete user by userId
     */
    public static boolean deleteUser(int userId) {
        return users.removeIf(user -> user.getUserId() == userId);
    }

    /**
     * Check if username already exists
     */
    public static boolean usernameExists(String username) {
        return findByUsername(username) != null;
    }

    /**
     * Check if email already exists
     */
    public static boolean emailExists(String email) {
        return findByEmail(email) != null;
    }

    /**
     * Get total number of users
     */
    public static int getTotalUsers() {
        return users.size();
    }
}
