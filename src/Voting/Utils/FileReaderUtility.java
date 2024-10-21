package Voting.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Voting.Models.User;

public class FileReaderUtility {

    private static final String FILE_PATH = "src/Resources/password/user.txt"; // The path to the text file storing user data.

    // Method to read all users from the file
    public static List<User> readAllUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    String password = parts[3];
                    users.add(new User(id, name, email, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to find a user by email
    public static User getUserByEmail(String email) {
        List<User> users = readAllUsers();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    // Method to check if a user exists by email
    public static boolean userExists(String email) {
        return getUserByEmail(email) != null;
    }

    // Method to find a user by ID
    public static User getUserByID(int id) {
        List<User> users = readAllUsers();
        for (User user : users) {
            if (user.getID() == id) {
                return user;
            }
        }
        return null;
    }
}
