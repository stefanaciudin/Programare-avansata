# Laborator 1
An instance of the "Best Route Problem" consists of locations and roads. Locations may be cities, airports, gas stations, etc.
Two locations may be connected by a road, or not. Roads may be highways, express, country, etc.

- Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).
- Each road has a type, length and a speed limit. The length of a road should not be less than the euclidian distance between the location coordinates.
We consider the problem of determining the "best" route from one location to another.

The main specifications of the application are:

## Compulsory
- Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
- The location and road types will be implemented as enums.
- Each class should have appropriate constructors, getters and setters.
Use the IDE features for code generation, such as generating getters and setters.
- The toString method form the Object class must be properly overridden for all the classes.
Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
- Create and print on the screen various objects of the two classes.

Clasa *Location* conține:
- nume
- tip (LocationType)
- coordonatele *x* și *y* ale locației.

Pentru fiecare câmp al clasei au fost implementate metode de get și set.

Clasa *Road* conține:
- start și end de tip *Location*
- tip (RoadType)
- lungime
- limită de viteză.

Pe lângă metodele de get și set, a fost implementată o metodă pentru a verifica dacă lungimea unui drum este validă (nu este mai mică decât distanța euclidiană dintre coordonatele celor două locații).

Clasa *TestLocationRoad* a fost implementată pentru testarea metodelor implementate.