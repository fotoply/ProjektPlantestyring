package ighc.data;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class Property {
    private double high;
    private double low;
    private double frequency;
    private double dutycycle;

    public Property(double high, double low, double frequency, double dutycycle) {
        this.high = high;
        this.low = low;
        this.frequency = frequency;
        this.dutycycle = dutycycle;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getDutycycle() {
        return dutycycle;
    }

    public void setDutycycle(double dutycycle) {
        this.dutycycle = dutycycle;
    }
}
