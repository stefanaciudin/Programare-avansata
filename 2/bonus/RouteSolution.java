package bonus;

import java.util.*;

import static java.lang.Math.sqrt;

/**
 * Class used to solve the shortest route problem - has an implementation of Dijkstra's algorithm
 * to find the shortest path between two locations using the available roads
 * The locations and roads are generated randomly.
 */

public class RouteSolution {
    private static ArrayList<Road> roads = new ArrayList<>();
    private static ArrayList<Location> locations = new ArrayList<>();

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        RouteSolution sol = new RouteSolution();
        int locationsNumber = 100;
        int roadsNumber = 2500;
        sol.generateLocations(locationsNumber);
        sol.generateRoads(locationsNumber, roadsNumber);
        // RouteProblem pb = new RouteProblem(locations, roads);
        System.out.println(locations);
        System.out.println(roads);
        List<Location> ans;
        for (int i = 0; i < locationsNumber; i++)
            for (int j = i + 1; j < locationsNumber; j++) {
                ans = sol.findShortestPath(locations.get(i), locations.get(j));
                System.out.println("Shortest path between " + locations.get(i) + " and " + locations.get(j) + " is " + ans);
            }

        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Running time: " + runningTime + ", memory increase: " + memoryIncrease);
    }

    public ArrayList<Location> findShortestPath(Location start, Location end) {

        // initialize the distances map with infinity
        // for each location we keep the shortest found distance
        // for starters - it's infinity for each location
        HashMap<Location, Float> distances = new HashMap<>();
        for (Location location : locations) {
            distances.put(location, Float.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0F);

        // initialize the visited set and previous map
        // in the visited set we keep the visited locations
        // the previous map is used to print the reconstructed shortest path
        Set<Location> visited = new HashSet<>();
        Map<Location, Location> previous = new HashMap<>();
        RouteProblem problem = new RouteProblem(locations, roads);

        if (!problem.canReach(start, end)) {
            return null; // return null if end is not reachable from start
        }

        // loop through all locations
        while (visited.size() < locations.size()) {
            Location current = null;
            Float minDistance = Float.POSITIVE_INFINITY; // the minimum distance is infinity at first
            // find the unvisited location with the smallest distance
            // so - we check if it is not visited and if the current distance is smaller
            // than the one we have already found
            for (Location location : locations) {
                if (!visited.contains(location) && distances.get(location) < minDistance) {
                    current = location;
                    minDistance = distances.get(location);
                }
            }

            if (current == null) { // there was no path found to the destination
                return null;
            }

            // mark the current location as visited
            visited.add(current);

            // update the distances of the neighboring locations
            for (Road road : getRoadsFromLocation(current)) { // for each road starting from the current location
                Location neighbor = road.getEnd(); // a neighbour location will be one that is at the end of the current road
                Float distanceThroughCurrent = distances.get(current) + road.getLength(); // add to the current distance the distance of the current road
                if (distanceThroughCurrent < distances.get(neighbor)) { // if this distance is smaller
                    distances.put(neighbor, distanceThroughCurrent); // we add it to the distance hash map
                    previous.put(neighbor, current); // and mark the previous location we have visited
                }
            }
        }

        // building the shortest path by following the previous map
        ArrayList<Location> shortestPath = new ArrayList<>();
        Location location = end;
        while (previous.containsKey(location)) { // we add to the shortest path array
            // starting from the end
            // until we cant find neighbours anymore. which means we have reached the start
            shortestPath.add(location);
            location = previous.get(location);
        }
        shortestPath.add(start); // we add the starting location
        Collections.reverse(shortestPath);// and reverse the array since we started with the end

        return shortestPath;
    }

    private ArrayList<Road> getRoadsFromLocation(Location l) { // gets the roads starting from location l
        ArrayList<Road> roads = new ArrayList<>();
        for (Road road : RouteSolution.roads) {
            if (road.getStart().equals(l))
                roads.add(road);
        }
        return roads;
    }

    public void generateRoads(int nrLocations, int nrRoads) {
        Random random = new Random();
        //generate random highways
        for (int i = 0; i < nrRoads; i++) {
            Location start = locations.get(random.nextInt(nrLocations)); //pick a random location
            Location end = locations.get(random.nextInt(nrLocations));
            //to generate a valid road, we add a float constant to the euclidean distance
            //between the start and the end location
            float length = random.nextFloat() * 100 + getDistance(start.getX(), start.getY(), end.getX(), end.getY());
            int speedLimit = random.nextInt(100) + 10;
            int lanes = random.nextInt(6);
            if (!start.equals(end)) {
                roads.add(new Highway(length, speedLimit, start, end, lanes));
                roads.add(new Highway(length, speedLimit, end, start, lanes)); // if there exists a road from A to B - the road also exists from B to A
            } else i--; //we stay at the same step and generate start and end again;
        }
    }

    public void generateLocations(int nrLocations) {
        Random random = new Random();
        //generate random cities
        for (int i = 0; i < nrLocations; i++) {
            String name = "City " + i;
            int x = random.nextInt(1000); //generates a random x smaller than 1000
            int y = random.nextInt(1000);
            int population = random.nextInt(300_000);
            locations.add(new City(name, x, y, population));
        }
    }


    private float getDistance(float startX, float startY, float endX, float endY) { // method used to get the euclidean distance between two locations
        float dist1 = startX - endX;
        float dist2 = startY - endY;
        return (float) sqrt(dist1 * dist1 + (double) (dist2 * dist2));
    }

}