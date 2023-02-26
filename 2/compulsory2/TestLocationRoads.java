package compulsory2;

public class TestLocationRoads {

    public static void main(String[] args) {
        Location one = new Location("One", LocationTypes.CITY, 1, 2);
        Location two = new Location("Two", LocationTypes.CITY, 3, 4);
        Road oneTwo = new Road(RoadTypes.COUNTRY_ROAD, 10, 120, one, two);
        System.out.println("First location: " + one.getName() + ", type: " + one.getType());
        System.out.println("Second location: " + two.getName() + ", type: " + two.getType());
        System.out.println("First road has type: " + oneTwo.getType() + ", max speed: " + oneTwo.getSpeedLimit() + " and length: " + oneTwo.getLength());
        if (oneTwo.isValid())
            System.out.println("This road is valid");
        else
            System.out.println("This road is not valid");

    }

}
