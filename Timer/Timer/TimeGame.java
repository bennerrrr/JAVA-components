package Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TimeGame {
    
    

    public static void main(String[] args) {
     
        Timer t = new Timer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Random rand = new Random();
        int randomSecond = rand.nextInt(20) + 3; // Random hour between 3 and 20

        System.out.println("Try and stop the timer at " + randomSecond + " seconds!");
        System.out.println("Press Enter to start the timer...");

        try {
            reader.readLine(); // Wait for user to press Enter
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            t.start(); // Start the timer
            System.out.println("Timer started! Press Enter to stop it...");

            try {
                reader.readLine(); // Wait for user to press Enter
            } catch (IOException e) {
                e.printStackTrace();
            }

            t.Stop(); // Stop the timer


            double elapsedSeconds = Double.parseDouble(t.timeElapsed());
            if (Math.abs(elapsedSeconds - randomSecond) >= 1) {
                System.out.println("You stopped at " + t.Second() + " seconds. Try again!");
            } else {
                
                System.out.println("Congratulations! You stopped the timer at " + randomSecond + " seconds.");
                break; // Exit the loop if the user stopped at the correct time
            }
        }

        t.reset(); // Reset the timer before starting



    }

}
