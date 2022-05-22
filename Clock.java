public class Clock {
    public int hour;
    public int minute;
    static final int MAX_HOUR = 23;
    static final int MAX_MINUTE = 59;
    static final int MIN_HOUR = 0;
    static final int MIN_Minute = 0;

    public Clock(int hour, int minute) {
        if (hour>MAX_HOUR || hour<MIN_HOUR)
            hour = 0;
        if (minute>MAX_MINUTE || hour<MIN_Minute)
            minute = 0;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int hashCode() {
        return 60 * this.hour + this.minute;
    }

    @Override
    public boolean equals(Object other) {
        Clock otherClock = (Clock) other;
        return this.hour == otherClock.hour && this.minute == otherClock.minute;
    }

    public int getHour() { return hour; }

    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }

    public void setMinute(int minute) { this.minute = minute; }

    @Override
    public String toString() {
        String HH = String.valueOf(this.hour);
        String MM = String.valueOf(this.minute);
        if (this.hour<10)
            HH = "0"+HH;
        if (this.minute<10)
            HH = "0"+MM;
        String currentTime = String.join(":","HH","MM");
        return currentTime;
    }

}


