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

## Homework

- Create the complete model: Person, Programmer, Designer, Company. All persons have a birth date. Each class must have at least one specific property, that others don't have (be creative).
- Each person will contain a Map defining the relathionships to other persons or companies.
- Create the Network class containing a List of identifiable nodes.
- Create a method that computes the importance of a node in the network, as the number of its connections to other nodes.
- Create a network object containing persons, companies and relationships and print it on the screen. When printing the network, the nodes must be ordered according to their importance.

La clasa *Person*, au fost adăugate clasele *Designer* și *Programmer*, care moștenesc din aceasta. Clasele *Designer* și *Programmer* au câte o proprietate specifică. Clasa person are un map numit *relationships*, pentru a stoca relațiile definite. Clasa *Network* conține o listă de noduri, o funcție pentru a adăuga noduri la lista de noduri, o funcție pentru a returna importanța unui nod și o funcție pentru a afișa nodurile din network - înainte de a fi afișate, nodurile sunt sortate în ordinea importanței.

## Bonus

- Implement an efficient agorithm to determine if there are nodes in this networks which, if they are removed, disconnect the network.
- Identify the blocks of the network, that is subgraphs that are maximally 2-connected.
- Create JUnit tests for your algorithms.

A fost implementat primul algoritm, cu o complexitate de *O(m+n)*, după metoda prezentată pe slide-urile laboratorului. Algortimul parcurge rețeaua, reprezentată ca un graf - nodurile sunt reprezentate de persoane și companii, iar muchiile de relațiile dintre acestea. După ce toata rețeaua, reprezentată ca o listă de adiacență, a fost parcursă, într-un vector vor fi salvate nodurile care o deconectează - acestea vor fi afișate. Pentru a verifica dacă algoritmul se execută corect, a fost creat și un test JUnit.
