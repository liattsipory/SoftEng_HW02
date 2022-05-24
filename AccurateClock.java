public class AccurateClock extends Clock {
    /**
     * this class represents clock that is accurate to level of seconds,
     * and setting finals of the max and min seconds.
     */
    public int seconds;
    static final int MAX_SECONDS = 59;
    static final int MIN_SECONDS = 0;

    /**
     * This constructor Sets an accurate clock and initialize it with the time.
     * @param hour - the hour of the clock
     * @param minute - the minutes of the clock
     * @param seconds - the seconds of the clock
     */

    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        if((seconds > MAX_SECONDS) || (seconds < MIN_SECONDS)) this.seconds = 0;
        else this.seconds = seconds;
    }

    /**
     * Overriding toString.
     * @return a string that represents the time of the clock in a format: HH:mm:ss.
     */

    @Override
    public String toString() {
        String secondsString;
        if (this.seconds < 10) secondsString = String.join("", "0", String.valueOf(this.seconds));
        else secondsString = String.valueOf(this.seconds);
        String currentTime = String.join(":", super.toString(), secondsString);
        return currentTime;
    }

    /**
     * Overriding hashCode.
     * @return The hashCode of this accurate clock. An accurate clock with the exact same hours, minutes, and seconds
     * will have the same hash code
     */

    @Override
    public int hashCode() {
        return (22*1000000 + super.hour*10000 + super.minute*100 + this.seconds);
    }

    /**
     * Overriding equals, based on the hashCodes of the clocks.
     * @param other - the other clock we compare this clock to.
     * @return - true if they are equals. false if not.
     */

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Clock) {
            return (other.hashCode() == this.hashCode());
        }
        else return false;
    }

}
