package extraChallenge;

public class Weather {
    private String dev_id;
    private String name;
    private Location location;
    private String keep_record;
    private String time;
    private String year;
    private String month;
    private String dayofweek;
    private Double airtemp;
    private Double atmosphericpressure;
    private Double gustspeed;
    private Double precipitation;
    private Double relativehumidity;
    private Double solar;
    private Double strikedistance;
    private Double strikes;
    private Double vapourpressure;
    private Double winddirection;
    private Double windspeed;

    public Weather() {}

    public Weather(String dev_id, String name, Location location, String keep_record, String time, String year, String month, String dayofweek, Double airtemp, Double atmosphericpressure, Double gustspeed, Double precipitation, Double relativehumidity, Double solar, Double strikedistance, Double strikes, Double vapourpressure, Double winddirection, Double windspeed) {
        this.dev_id = dev_id;
        this.name = name;
        this.location = location;
        this.keep_record = keep_record;
        this.time = time;
        this.year = year;
        this.month = month;
        this.dayofweek = dayofweek;
        this.airtemp = airtemp;
        this.atmosphericpressure = atmosphericpressure;
        this.gustspeed = gustspeed;
        this.precipitation = precipitation;
        this.relativehumidity = relativehumidity;
        this.solar = solar;
        this.strikedistance = strikedistance;
        this.strikes = strikes;
        this.vapourpressure = vapourpressure;
        this.winddirection = winddirection;
        this.windspeed = windspeed;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String isKeep_record() {
        return keep_record;
    }

    public void setKeep_record(String keep_record) {
        this.keep_record = keep_record;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public Double getAirtemp() {
        return airtemp;
    }

    public void setAirtemp(Double airtemp) {
        this.airtemp = airtemp;
    }

    public Double getAtmosphericpressure() {
        return atmosphericpressure;
    }

    public void setAtmosphericpressure(Double atmosphericpressure) {
        this.atmosphericpressure = atmosphericpressure;
    }

    public Double getGustspeed() {
        return gustspeed;
    }

    public void setGustspeed(Double gustspeed) {
        this.gustspeed = gustspeed;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getRelativehumidity() {
        return relativehumidity;
    }

    public void setRelativehumidity(Double relativehumidity) {
        this.relativehumidity = relativehumidity;
    }

    public Double getSolar() {
        return solar;
    }

    public void setSolar(Double solar) {
        this.solar = solar;
    }

    public Double getStrikedistance() {
        return strikedistance;
    }

    public void setStrikedistance(Double strikedistance) {
        this.strikedistance = strikedistance;
    }

    public Double getStrikes() {
        return strikes;
    }

    public void setStrikes(Double strikes) {
        this.strikes = strikes;
    }

    public Double getVapourpressure() {
        return vapourpressure;
    }

    public void setVapourpressure(Double vapourpressure) {
        this.vapourpressure = vapourpressure;
    }

    public Double getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(Double winddirection) {
        this.winddirection = winddirection;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }
}
