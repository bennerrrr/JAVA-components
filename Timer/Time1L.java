package components.Timer;
import java.util.Calendar;
import java.util.TimeZone;
//                date.month = 0;
//                date.day = 0;
//                date.year = 0;
//
//                time.hour = 0;
//                time.minute = 0;
//                time.second = 0;
//                time.am = true;
//
//                duration = 0;
public class Time1L implements Time {


    // This class extends the Timer class

    // Time class
    // This class is used to represent the time of day
    // It contains the hour, minute, second, and whether it is AM or PM
    // It also contains methods to get and set the time, and to clear the time
    // The time is represented in 12-hour format, with AM and PM
    // The time is represented in the format HH:MM:SS AM/PM
    int month;
    int day;
    int year;
    int hour;
    int minute;
    int second;
    boolean am;


    
    public Time1L() {
        createNewRep();
    }


    private void createNewRep() {
        TimeZone tz = TimeZone.getTimeZone("America/New_York");
        Calendar c = Calendar.getInstance(tz);

        //sets current time
        this.hour = c.get(Calendar.HOUR);
        this.minute = c.get(Calendar.MINUTE);
        this.second = c.get(Calendar.SECOND);
        this.am = c.get(Calendar.HOUR_OF_DAY) < 12;

        //sets current date
        this.month = c.get(Calendar.MONTH) + 1; // Months are 0-based in Calendar
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.year = c.get(Calendar.YEAR);
    }

    public Time1L(int hour, int minute, int second, boolean am) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.am = am;
    }

    @Override
    public int Month() { return this.month; } // or throw UnsupportedOperationException
    @Override
    public int Day() { return this.day; }
    @Override
    public int Year() { return this.year; }
    @Override
    public int Hour() { return this.hour; }
    @Override
    public int Minute() { return this.minute; }
    @Override
    public int Second() { return this.second; }
    @Override
    public boolean isAM() { return this.am; }
    @Override
    public String toString() {
        String date = String.format("%02d/%02d/%04d", Month(), Day(), Year());
        String time = String.format("%02d:%02d:%02d %s", hour, minute, second, am ? "AM" : "PM");
        return date + "   " + time; 
    }
    @Override
    public void reset(){createNewRep();}

    /**
     *  This method clears the time by setting the hour, minute, and second to 0
     * 
     *  @ensures value of hour, minute, and second is 0
     * 
     *  @ensures value of am is true
     */
    @Override
    public void clear() {
        hour = 0;
        minute = 0;
        second = 0;
        am = true;
    }

}
