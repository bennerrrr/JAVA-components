import java.util.*;
import static java.util.Calendar.*;

public class DeskMan{

     public class timer{


          class Date1{
               int month;
               int day;
               int year;
          }

          class Time1{
               int hour;
               int minute;
               int second;
               boolean am;
          }


          Date1 date;
          Time1 time;
          int duration;


          public timer(){

               createNewRep();
          }


          public void createNewRep(){
               TimeZone tz = TimeZone.getTimeZone("America/New_York");
               Calendar c = Calendar.getInstance(tz);

               date = new Date1();
               time = new Time1();

               //sets current date
               this.date.month = c.get(MONTH);
               this.date.day = c.get(DATE);
               this.date.year = c.get(YEAR);

               //sets current time
               this.time.hour = c.get(HOUR);
               this.time.minute = c.get(MINUTE);
               this.time.second = c.get(SECOND);

               

               if(c.get(HOUR_OF_DAY) > 12){
                    this.time.am = false;
               }else{
                    this.time.am = true;
               }


          }


          public void clear(){
               createNewRep();
          }

          
          @Override
          public String toString(){
               String date;
               String timeStr = String.format("%d:%02d:%02d", this.time.hour, this.time.minute, this.time.second);

               if(this.time.am){

                    date = "Date: " + this.date.month + "/" + this.date.day + "/" + this.date.year + "\n" +
                           "Time: " + timeStr + " AM";

               }else{

                    date = "Date: " + this.date.month + "/" + this.date.day + "/" + this.date.year + "\n" +
                           "Time: " + timeStr + " PM";
               }

               return date;
          }

     }

     public static void main(String[] args) {
          DeskMan d = new DeskMan();
          timer t = d.new timer();


          
          System.out.println(t.toString());

     }
}