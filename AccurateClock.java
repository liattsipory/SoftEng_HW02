public class AccurateClock extends Clock {
    private int seconds;

    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        this.seconds = seconds;
    }

    @Override
    public int hashCode() {
        return 60 * hour + minute;
    }

    @Override
    public boolean equals(Object other) {
        Clock otherClock = (Clock) other;
        return this.hour == otherClock.hour && this.minute == otherClock.minute;
    }
}
