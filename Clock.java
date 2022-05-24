public class Clock {
    /**
     * This class represents a clock that is accurate to level of minutes,
     * and setting finals of the max and min of hours and minutes.
     */
    public int hour;
    public int minute;
    static final int MAX_HOUR = 23;
    static final int MAX_MINUTE = 59;
    static final int MIN_HOUR = 0;
    static final int MIN_Minute = 0;

    /**
     * This constructor Sets a clock and initialize it with the time.
     * @param hour - the hour of the clock
     * @param minute - the minutes of the clock
     */

    public Clock(int hour, int minute) {
        if (hour>MAX_HOUR || hour<MIN_HOUR)
            hour = 0;
        if (minute>MAX_MINUTE || hour<MIN_Minute)
            minute = 0;
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Overriding hashCode.
     * @return The hashCode of this clock. A clock (that is not an accurate clock)
     *         with the exact same hours, minutes, and seconds will have the same hash code.
     */

    @Override
    public int hashCode() {
        return 11*1000000 + 10000 * this.hour + 100 * this.minute;
    }

    /**
     * Overriding equals, based on the hashCodes of the clocks.
     * @param other - the other clock we compare this clock to.
     * @return - true if they are equals. false if not.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Clock) {
            return (this.hashCode() == other.hashCode());
        }
        else return false;
    }


    /**
     * Overriding toString.
     * @return a string that represents the time of the clock in a format: HH:mm.
     */

    @Override
    public String toString() {
        String HH = String.valueOf(this.hour);
        String MM = String.valueOf(this.minute);
        if (this.hour<10)
            HH = "0"+HH;
        if (this.minute<10)
            MM = "0"+MM;
        String currentTime = String.join(":",HH,MM);
        return currentTime;
    }

}


