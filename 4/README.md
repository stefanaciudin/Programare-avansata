# Laborator 4

The Student-Project Allocation Problem
An instance of this problem consists of students and projects. Each student has a list of projects that are admissible.
A matching is a set of pairs (student, project) such that each student is assigned to at most one project and each project is assigned to at most one student. We consider the problem of creating a maximum cardinality matching between students and projects.

Example: 3 students (S0,S1,S2) and 3 projects (P0,P1,P2).
Projects considered admissible by: S0={P0,P1,P2}, S1={P0,P1}, S2={P0}.
The maximum cardinality matching should be: {S0-P2, S1-P1, S2-P0}.

The main specifications of the application are:

## Compulsory

- Create a Maven project.
- Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.
- Create the students and the projects described in the example. Use streams in order to easily create the objects.
- Put all the students in a LinkedList and print them sorted by their names.
- Put all the projects in a TreeSet and print them sorted by their names.

Au fost create clasele *Project*, *Student* și *TestStudentProject*, cea din urmă fiind creată pentru a testa obiecte create în primele două clase. Atât clasele *Project* și *Student* au ca atribut numele proiectului sau studentului respectiv. În clasa *TestStudentProject*, au fost create obiectele descrise în exemplu, studenții au fost stocați într-o listă înlănțuită, iar proiectele într-un TreeSet. Ambele seturi de obiecte se afișează la ecran sortate în ordinea alfabetică a numelor acestora.

## Homework

- Create a class that describes the problem.
- Using Java Stream API, write a query that display all the students that have a number of preferences lower than the average number of preferences.
- Use a third-party library in order to generate random fake names for students and projects.
- Create a Greedy algorithm in order to solve the problem.

S-a adăugat o clasă suplimentară pentru a modela și rezolva problema dată - *AllocationProblem*. Pentru a genera o instanță mare a problemei, se folosește librăria *JavaFaker*, care generează numele studenților random. Pentru generarea proiectelor, metoda *generatePreferences* va genera un număr de preferințe mai mare decât numărul de studenți, apoi va alege random din acest set de proiecte generat pe care i le va atribui fiecărui student. Metoda *printStudents* afișează studenții cu un număr de preferințe mai mic decât media totală a preferințelor studenților.

## Bonus

- Implement an algorithm that determines the maximum cardinality matching... or you may use the following libraries in order to solve it:
*JGraphT*, *Graph4J*
- Create a random problem generator (with thousands of objects) and test the performance of the implementation (try both libraries).
- Compare the results with the ones obtained by the greedy algorithm.
- Determine a minimum cardinality set formed of students and projects with the property that each admissible pair (student-project) contains at least an element of this set.
- Determine a maximum cardinality set of of students and projects such that there is no admissible pair (student-project) formed with elements of this set.

Pentru a determina cuplajul de cardinal maxim, s-a creat graful (care are ca noduri obiecte de tip *Proiect* și *Student*, iar două noduri vor fi conectate dacă exsită un student care are ca preferință acel proiect), asupra căruia s-a aplicat algoritmul din librăria *JgraphT*. Pentru a genera o instanță mare a problemei, se folosește generatorul implementat la **Homework**, pentru o instanță cu 5000 de studenți și 25000 de proiecte în total.

Performanța algoritmilor de tip greedy și cel din librăria *JGraphT* este măsurată prin compararea timpului de execuție și a memoriei consumate, pentru care am implementat două metode.
Pentru a rezolva ultimele două subpuncte, am implementat o funcție care determină **minimum vertex cover** și **maximum independent set**. Pentru a crește performanța metodei, întâi s-a folosit alogritmul pentru **minimum vertex cover**, apoi nodurile rămase neselectate vor reprezenta **maximum independent set** (sunt exact nodurile care formează vertex cover în graful complement).
