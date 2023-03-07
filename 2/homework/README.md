# Laborator 2
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

## Homework
- Create a class that describes an instance of the problem.
- Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
- Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.)
- Implement a method that determines if a problem's instance is valid.
- Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
- Write doc comments in your source code and generate the class documentation using javadoc.

A fost adăugată clasa *RouteProblem* pentru a descrie o instanță a problemei *Best route problem*.
În loc de enum, au fost implementate clasele *City*, *Airport* și *GasStation* - care moștenesc din clasa *Location* și clasele *Highway*, *Express*, *CountryRoad* care moștenesc din clasa *Road*. Pentru aceste clase, s-a făcut override la metoda Object.equals - acesta se face în fiecare clasă în parte, deoarece toate clasele au câmpuri suplimentare față de clasa din care moștenesc. 
În clasa *RouteProblem*, locațiile și drumurile sunt reținute în două list-uri - în acestea nu se poate adăuga de două ori aceeasi valoare, deoarece metodele *addLocation* și *addRoad* nu permit acest lucru.
Pentru a verifica dacă o instanță de tip *RouteProblem* este validă, am considerat ca toate drumurile introduse trebuie să fie valide (acest lucru se poate verifica folosind metoda *isValid* din clasa *Road*) și să nu avem două locații sau drumuri identice introduse. Cum a doua condiție se verifică automat la introducerea variabilelor in liste, a fost necesară doar verificarea primei condiții, de metoda *isValid* din clasa *RouteProblem*.
Pentru a verifica dacă se poate ajunge de la o locație dată la alta, folosind drumurile introduse, se va apela metoda *canReach*, care ulterior va apela o metoda helper. Metoda helper "parcurge" drumurile începând cu cele din locația de start și verifică dacă poate ajunge la locația finală în mod recursiv, folosind capetele drumurilor existente.

## Bonus
- Create a class to describe the solution.
- Implement an algorithm to find the best route from a location to another, either as the shortest route, or the fastest route.
- Generate large random instances of the problem and analyze the performance of your algorithm (running times, memory consumption).

Clasa *RouteSolution* este utilizată pentru a modela soluția problemei *RouteProblem* - aceasta implementează algoritmul lui Dijkstra pentru problema dată. Datele problemei (drumurile și locațiile) sunt generate radnom de funcțiile *generateRoads* și *generateLocations*. În main se rezolvă problema shortest path pentru oricare 2 locații, folosind două bucle for. Pentru fiecare pereche se afișează drumul cel mai scurt. La final, se va afișa timpul de execuție și memoria consumată de algoritm.