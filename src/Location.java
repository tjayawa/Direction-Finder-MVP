import java.lang.String;
public class Location {

    private double latitude;
    private double longitude;
    private String name;

    public Location(String name, double latitude, double longitude) throws IllegalArgumentException {
        if ((latitude >= -90.0 && latitude <= 90.0) && (longitude >= -180.0 && longitude <= 180.0)) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Location(double latitude, double longitude) throws IllegalArgumentException {
        if ((latitude >= -90.0 && latitude <= 90.0) && (longitude >= -180.0 && longitude <= 180.0)) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.name = "";
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getLatitude() {return this.latitude;}

    public double getLongitude() {return this.longitude;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public static Location parseLocation(String location) throws IllegalArgumentException {
        if (location.matches("\\([+-]?(\\d+\\.\\d+), [+-]?(\\d+\\.\\d+)\\)")) {
            try {
                double latitude = Double.parseDouble(location.substring(location.indexOf("(") + 1, location.indexOf(",")));
                double longitude = Double.parseDouble(location.substring(location.indexOf(" ") + 1, location.indexOf(")")));
                if ((latitude >= -90.0 && latitude <= 90.0) && (longitude >= -180.0 && longitude <= 180.0)) {
                    return new Location(latitude, longitude);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("%f\u00B0 %s, %f\u00B0 %s", latitude, (latitude >= 0.0 ? "N" : "S"),
                longitude, (longitude >= 0.0 ? "E" : "W"));
    }
}
