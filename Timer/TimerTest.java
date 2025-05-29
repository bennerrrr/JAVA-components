package components.Timer;

import java.util.Scanner;

import System;

public class TimerTest {
    
    public static void main(String[] args) {
        // This is just a placeholder for the main method.
        // You can create instances of Time1L and DeskMan here to test their functionality.
        Timer deskMan = new Timer();


        System.out.println(deskMan.start());
        // Simulate some time passing


        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to stop the timer...");
        scanner.nextLine(); // Wait for user input


        System.out.println(deskMan.Stop());

        deskMan.duration();
        System.out.println("Duration in seconds: " + deskMan.duration());
        System.out.println(deskMan.timeElapsed());
        System.out.println("Start Time: " + deskMan.StartTime.toString());
        System.out.println("End Time: " + deskMan.EndTime.toString());

        scanner.close();
    }

}
