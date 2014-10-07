package ighc.data;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class Stimulus {
    private Property temperature;
    private Property humidity;
    private Property light;
    private Property co2;
    private boolean enabled;

    public Stimulus(Property temperature, Property humidity, Property light, Property co2) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.co2 = co2;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Property getTemperature() {
        return temperature;
    }

    public void setTemperature(Property temperature) {
        this.temperature = temperature;
    }

    public Property getHumidity() {
        return humidity;
    }

    public void setHumidity(Property humidity) {
        this.humidity = humidity;
    }

    public Property getLight() {
        return light;
    }

    public void setLight(Property light) {
        this.light = light;
    }

    public Property getCo2() {
        return co2;
    }

    public void setCo2(Property co2) {
        this.co2 = co2;
    }
}
