package compulsory;

/**
 * Creates and prints various objects of the two classes created
 * Tests methods implemented
 */

public class TestLocationRoad {

    public static void main(String[] args) {
        Location one = new Location("One", LocationType.CITY, 1, 2);
        Location two = new Location("Two", LocationType.CITY, 3, 4);
        Road oneTwo = new Road(RoadType.COUNTRY_ROAD, 10, 120, one, two);
        System.out.println("First location: " + one.getName() + ", type: " + one.getType());
        System.out.println("Second location: " + two.getName() + ", type: " + two.getType());
        System.out.println("First road has type: " + oneTwo.getType() + ", max speed: " + oneTwo.getSpeedLimit() + " and length: " + oneTwo.getLength());
        if (oneTwo.isValid())
            System.out.println("This road is valid");
        else
            System.out.println("This road is not valid");

    }

}
