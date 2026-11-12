//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.IO;
public class Main {

    public static Location inputLocation(String type) {
        String name = IO.readln(String.format("Enter the %s location's name (Enter an empty string if no name)\n", type));
        if (name.matches("\\s*")) {name = null;}
        Location location = null;
        do {
            try {
                location = Location.parseLocation(IO.readln("Input Coordinates of Location:\n"));
            } catch (IllegalArgumentException e) {
                IO.println("Coordinates given are not formatted correctly");
            }
        } while (location == null);
        location.setName(name);
        return location;
    }

    public static void main(String[] args) {
        Location start = inputLocation("starting");
        Location end = inputLocation("ending");
        IO.println(Bearing.format(start, end));
    }
}