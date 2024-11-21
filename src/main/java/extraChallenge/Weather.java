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
    private double airtemp;
    private double atmosphericpressure;
    private double gustspeed;
    private double precipitation;
    private double relativehumidity;
    private double solar;
    private double strikedistance;
    private double strikes;
    private double vapourpressure;
    private double winddirection;
    private double windspeed;

    public Weather() {
    }

    public Weather(String dev_id, String name, Location location, String keep_record, String time, String year, String month, String dayofweek, double airtemp, double atmosphericpressure, double gustspeed, double precipitation, double relativehumidity, double solar, double strikedistance, double strikes, double vapourpressure, double winddirection, double windspeed) {
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

    public double getAirtemp() {
        return airtemp;
    }

    public void setAirtemp(double airtemp) {
        this.airtemp = airtemp;
    }

    public double getAtmosphericpressure() {
        return atmosphericpressure;
    }

    public void setAtmosphericpressure(double atmosphericpressure) {
        this.atmosphericpressure = atmosphericpressure;
    }

    public double getGustspeed() {
        return gustspeed;
    }

    public void setGustspeed(double gustspeed) {
        this.gustspeed = gustspeed;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getRelativehumidity() {
        return relativehumidity;
    }

    public void setRelativehumidity(double relativehumidity) {
        this.relativehumidity = relativehumidity;
    }

    public double getSolar() {
        return solar;
    }

    public void setSolar(double solar) {
        this.solar = solar;
    }

    public double getStrikedistance() {
        return strikedistance;
    }

    public void setStrikedistance(double strikedistance) {
        this.strikedistance = strikedistance;
    }

    public double getStrikes() {
        return strikes;
    }

    public void setStrikes(double strikes) {
        this.strikes = strikes;
    }

    public double getVapourpressure() {
        return vapourpressure;
    }

    public void setVapourpressure(double vapourpressure) {
        this.vapourpressure = vapourpressure;
    }

    public double getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(double winddirection) {
        this.winddirection = winddirection;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }
}
