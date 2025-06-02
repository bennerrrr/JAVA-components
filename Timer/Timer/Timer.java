package Timer;


public class Timer extends Time1L{


     Time StartTime;
     Time EndTime;
     int duration;



     public Timer() {
          createNewRep();
     }


     private void createNewRep() {
          StartTime = new Time1L();
          EndTime = new Time1L();
          duration = 0;
     }


     public String start(){

          this.StartTime.reset();

          return "**Started**   Start time: " + this.StartTime.toString();
     }

     public String Stop(){

          this.EndTime.reset();

          return "**Stopped**   End time: " + this.EndTime.toString();
     }

     public int duration(){
          int StartTime1 = this.StartTime.Hour() * 3600 + this.StartTime.Minute() * 60 + this.StartTime.Second();
          int EndTime1 = this.EndTime.Hour() * 3600 + this.EndTime.Minute() * 60 + this.EndTime.Second();
          duration = EndTime1 - StartTime1;
          return duration;
     }

     public String timeElapsed(){

          int hours = this.duration / 3600;
          int minutes = (this.duration % 3600) / 60;
          int seconds = this.duration % 60;

          return String.format("Elapsed time: %02d:%02d:%02d", hours, minutes, seconds);
     }

     
}