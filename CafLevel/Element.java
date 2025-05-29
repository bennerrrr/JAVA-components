package components.CafLevel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Element {

    //private final static Double CAFFINE_HALF_LIFE = 5.0; // in hours
    //in mg
    Double caffineContent;
    Map<Double, Double> caffineContentMap;
    int finalHour;
    Double finalValue;

    public Element(Double caffineContent) {
        this.caffineContent = caffineContent;
    }

    public Map<Double, Double> getCaffineContent() {
        Double caffineCont = this.caffineContent;
        Double content = caffineCont;
        Double halfLife = 5.0; // Half-life in hours

        Double hour = 1.0; // Move outside the loop

        this.caffineContentMap = new HashMap<>();
        this.caffineContentMap.put(hour, content); // Add initial content

        while (content >= 0.5) { // Continue until caffeine content is negligible
            // Calculate caffeine after each hour using half-life formula
            content = caffineCont * Math.pow(0.5, hour / halfLife);
            this.caffineContentMap.put(hour, content);
            hour++; // This will now properly increment
        }
        stats(); // Call stats method to print final hour and content map
        return this.caffineContentMap;
    }

    public String stats() {
        Double lastHour = Collections.max(caffineContentMap.keySet());
        this.finalHour = lastHour.intValue();
        this.finalValue = caffineContentMap.get(lastHour);  // Use the original Double key
    


        return "Caffeine content will be negligible after " + finalHour + " hours with " + this.finalValue + " mg remaining.";
    }

}