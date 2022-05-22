public class AccurateClock extends Clock {
    public int seconds;
    static final int MAX_SECONDS = 59;
    static final int MIN_SECONDS = 0;

    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        if((seconds > MAX_SECONDS) || (seconds < MIN_SECONDS)) this.seconds = 0;
        else this.seconds = seconds;
    }

    @Override
    public String toString() {
        String secondsString;
        if (this.seconds < 10) secondsString = String.join("", "0", String.valueOf(this.seconds));
        else secondsString = String.valueOf(this.seconds);
        String currentTime = String.join(":", super.toString(), secondsString);
        return currentTime;
    }

    @Override
    public int hashCode() {
        return (22*1000000 + super.hour*10000 + super.minute*100 + this.seconds);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Clock) {
            return (other.hashCode() == this.hashCode());
        }
        else return false;
    }

}
