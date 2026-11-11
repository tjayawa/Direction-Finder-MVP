import java.lang.Math;
public class Bearing {

    private static String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    private static double calculate(Location start, Location end) {
        double startLat = Math.toRadians(start.getLatitude());
        double startLong = Math.toRadians(start.getLongitude());
        double endLat = Math.toRadians(end.getLatitude());
        double endLong = Math.toRadians(end.getLongitude());

        double detlaLong = endLong - startLong;

        double y = Math.sin(detlaLong) * Math.cos(endLat);
        double x = (Math.cos(startLat) * Math.sin(endLat)) -
                (Math.sin(startLat) * Math.cos(endLat) * Math.cos(detlaLong));

        double bearingRad = Math.atan2(y, x);
        double bearingDeg = Math.toDegrees(bearingRad);
        return (bearingDeg + 360) % 360;
    }

    public static String format(Location start, Location end) {
        double bearing = calculate(start, end);
        int index = (int) Math.round((bearing / 45.0)) % 8;
        return String.format("Direction from %s to %s: %.1f %s",
                start.getName(), end.getName(), bearing, directions[index]);
    }

    private static String format(double bearing) throws IllegalArgumentException {
        if (bearing >= 0.0 && bearing <= 360.0) {
            int index = (int) Math.round((bearing / 45.0)) % 8;
            return String.format("%.1f %s", bearing, directions[index]);
        }
    }
}
