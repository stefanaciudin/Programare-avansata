package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to represent the best route problem - has an array of roads an array of locations
 * The methods implemented check if a location already exists in the array
 * or if the road already exists in the array and if it is valid or not.
 * The class also has a method called canReach - it checks in a recursive manner if we
 * can reach a location starting from another using the given roads.
 */

public class RouteProblem {
    private final ArrayList<Road> roads = new ArrayList<>();
    private final ArrayList<Location> locations = new ArrayList<>();

    private RouteProblem() {

    }

    public static void main(String[] args) { // test
        RouteProblem pb = new RouteProblem();
        City one = new City("One", 0, 0, 10_000);
        City two = new City("Two", 3, 4, 20_200);
        GasStation gas1 = new GasStation("GasStation1", 6, 8, 12);
        GasStation gas2 = new GasStation("GasStation2", 6, 10, 13);
        pb.addLocations(one);
        pb.addLocations(two);
        pb.addLocations(gas1);
        pb.addLocations(gas2);
        Road road1 = new CountryRoad(10, 40, one, two, "village");
        Road road2 = new Highway(7, 130, two, gas1, 4);
        Road road3 = new Express(12, 130, two, gas1, 4);
        pb.addRoad(road1);
        pb.addRoad(road2);
        pb.addRoad(road3);
        boolean valid = pb.isValid();
        boolean reachable = false;
        if (valid)
            reachable = pb.canReach(one, gas1);
        System.out.println("Is the problem valid? " + valid + " Can you reach location " + gas1 + " from location " + one + "? " + reachable);
    }

    private void addLocations(Location l) {
        if (!locations.contains(l)) // if the location isn't already added
            locations.add(l); // we add id to the list
        else System.out.println("This location " + l + " already exists");

    }

    private void addRoad(Road r) {
        if (!roads.contains(r)) // if the road isn't already added
            roads.add(r); // we add it to the list
        else System.out.println("This road " + r + " already exists");

    }

    private boolean isValid() {
        // an instance of the problem is valid if there aren't duplicates of the roads and locations
        // (which is being checked by the methods addRoad and addLocation)
        // and if the roads are valid, so the only thing we check here is if all the roads are valid.
        for (Road road : roads) {
            if (!road.isValid())
                return false;
        }
        return true;
    }

    public boolean canReach(Location start, Location end) {
        Set<Location> visited = new HashSet<>(); // using a hash set to avoid visiting the same location twice
        return canReachHelper(start, end, visited) || canReachHelper(end, start, visited);
    }

    private boolean canReachHelper(Location current, Location end, Set<Location> visited) {
        if (current.equals(end)) {
            return true;
        }
        visited.add(current);
        for (Road road : roads) // for each existent road
            if (road.getStart() == current && !visited.contains(road.getEnd()) && (canReachHelper(road.getEnd(), end, visited)))
                // if the start is the current value -- we have roads starting from the current point
                // we haven't reached the end and the method can find a path recursively -- we return true
                return true;
        visited.remove(current);
        return false; // couldn't find a path
    }
}