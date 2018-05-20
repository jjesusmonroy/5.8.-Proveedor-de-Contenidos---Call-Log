package gpsgooglemaps.monroy.com.a58calllog;

/**
 * Created by jjesusmonroy on 20/05/18.
 */

public class Call {
    String number,name,duration,type;

    public Call(String number, String name, String duration, String type) {
        this.number = number;
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
