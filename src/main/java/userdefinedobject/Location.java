package userdefinedobject;

public class Location {


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String location =null;
    private String date =null;



    public Location(String _location, String _date){
    this.location=_location;
    this.date=_date;

    }

}
