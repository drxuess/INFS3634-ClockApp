package xu.morgan.clockapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Clock {
    private Date time;
    private TimeZone timeZone;
    private String location;
    private String image;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
    public static final String DATE_FORMAT_12 = "h:mm a";
    public static final String DATE_FORMAT_24 = "HH:mm:ss";
    public enum TimeFormat {
        TWELVE, TWENTYFOUR
    }

    public Clock(String timeZone, String location, String image) {
        this.time = new Date();
        this.timeZone = TimeZone.getTimeZone(timeZone);
        DATE_FORMAT.setTimeZone(this.timeZone);
        DATE_FORMAT.applyPattern(DATE_FORMAT_12);
        this.location = location;
        this.image = image;
    }

    public String getTime(TimeFormat format){
        switch (format) {
            case TWELVE:
                DATE_FORMAT.applyPattern(DATE_FORMAT_12);
                break;
            case TWENTYFOUR:
                DATE_FORMAT.applyPattern(DATE_FORMAT_24);
                break;
        }
        return DATE_FORMAT.format(time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void updateTime() {
        time = new Date();
    }
}
