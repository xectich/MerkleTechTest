

/**
 * Time
 */
public class Time {
    //member variables
    private int hours;
    private int minutes;
    private int seconds;
    private String timeString;

    //constructors
    public Time(){
        hours = 0;
        minutes = 0;
        seconds = 0;
        timeString = "";
    }

    public Time (int hours,int minutes,int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        setTimeString();
    }

    //getters 
    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    public String getTimeString(){
        return timeString;
    }

    public void timeString(){
        System.out.println(timeString);
    }

    //setters 

    /**
     * Sets the timeString after constructing the element or independently
     * @param hours
     * @param minutes
     * @param seconds
     */
    public void setTimeString(){
        //check if seconds are more than 59 and calculate how much there are
        //for every 60 seconds add one more to minutes
        if(seconds > 59){
            int remainder = seconds % 60;
            minutes += Math.round(seconds/60);
            seconds = remainder;
        }

        //same with minutes as the seconds, only add an extra hour for each 60 minuites.
        if(minutes > 59){
            int remainder = minutes % 60;
            hours += Math.round(minutes/60);
            minutes = remainder;
        }

        //format the string without using to much language provided functions
        timeString = String.format("%02d:%02d:%02d", hours, minutes,seconds);

    }

    //reuse function from before
    public void scale(int secs){
        seconds += secs;
        setTimeString();
    }

    public static void main(String[] args){
        Time t = new Time(1,30,20);
        t.timeString();
        t.scale(400);
        t.timeString();

        Time t1 = new Time( 1, 100, 0 );
        t1.timeString();
    }
}