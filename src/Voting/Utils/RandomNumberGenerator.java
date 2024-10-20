package Voting.Utils; 

import java.util.Random;

public class RandomNumberGenerator {

    // Method to generate a random 4-digit number
    public int generateRandomNumber() {
        Random random = new Random();
        // Generates a random number between 1000 and 9999 (inclusive)
        return 1000 + random.nextInt(9000);
    }
}
