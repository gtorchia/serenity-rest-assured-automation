package userdefinedobject;

public class SinglePoint {

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String lognituide) {
        this.longitude = lognituide;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String longitude;
    private String latitude;
    private String date;

    public SinglePoint(String longitude, String latitude, String date) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }


}
