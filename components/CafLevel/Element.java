package components.CafLevel;

import java.util.List;

public class Element{

    //private final static Double CAFFINE_HALF_LIFE = 5.0; // in hours
    //in mg
    Double caffineContent;
    List<Double> caffineContentList;



    public Element(Double caffineContent) {
        this.caffineContent = caffineContent;
    }




    
    public List<Double> getCaffineContent() {
        
        Double caffineCont = this.caffineContent;
        Double content = 0.0;


        while (content >= 0.1) { // Continue until caffeine content is negligible
        
            Double hour = 1.0;

            content = caffineCont * Math.pow(hour, hour/2.0);
            this.caffineContentList.add(content);
            hour++;

        }
        return caffineContentList;


    }



} 
