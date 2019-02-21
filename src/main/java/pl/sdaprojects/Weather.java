package pl.sdaprojects;

import java.time.LocalDate;

public class Weather {
    private String date;
    private int max_temp;
    private int mean_temp;
    private int min_temp;

    public Weather(String data, int max_temp, int mean_temp, int min_temp) {
        this.date = data;
        this.max_temp = max_temp;
        this.mean_temp = mean_temp;
        this.min_temp = min_temp;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "data='" + date + '\'' +
                ", max_temp=" + max_temp +
                ", mean_temp=" + mean_temp +
                ", min_temp=" + min_temp +
                '}';
    }


}