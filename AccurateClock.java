public class AccurateClock extends Clock {
    private int seconds;
    static final int MAX_SECONDS = 59;
    static final int MIN_SECONDS = 0;

    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        if((seconds > MAX_SECONDS) || (seconds < MIN_SECONDS)) this.seconds = 0;
        else this.seconds = seconds;
    }

    @Override
    private String toString() {
        String secondsString;
        if (this.seconds < 10) secondsString = String.join("", "0", String.valueOf(this.seconds));
        else secondsString = String.valueOf(this.seconds);
        String currentTime = String.join(":", super.toString(), secondsString);
        return currentTime;
    }

    @Override
    private int hashCode() {

    }

}
