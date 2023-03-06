# Laborator 3
A social network contains persons and companies, each of them identifiable by unique names.
In this network there are relationships of the following types: person-to-person (if they know each other, how?), and person-to-company (if the person works for that company, on what position?).
There may be various types of "specialized" persons in the network, such as programmers or designers.

The main specifications of the application are:

## Compulsory
- Create an object-oriented model of the problem. You should have at least the following classes Person, Company.
- Both classes should implement the interface java.util.Comparable. The natural order of the objects will be given by their names.
- Create the interface Node that defines the method used to obtain the name of a person or company. The classes above must implement this interface.
- Create a java.util.List containing node objects and print it on the screen.

Au fost implementate clasele *Person* și *Company*, dar și interfața *Node*. În interfața *Node* se regăsește metoda de tip String *getName()*, care este implementată de clasele *Person* și *Company* și returnează numele persoanei sau al companiei respective. Ambele clase implementează și interfața *Comparable* - ordinea obiectelor este dată de ordinea alfabetică a numelor acestora.
