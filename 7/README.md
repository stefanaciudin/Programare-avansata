# Laborator 7

*Concurrency*
Consider a map represented as a n x n square matrix, each cell being an individual location of the map.
A number of robots (agents) must explore all the cells of the matrix. They are initially located at random positions and are allowed to move in any direction inside the map. Two robots cannot be in the same cell at once.
The robots can access a shared memory containing tokens (for example, numbers from 1 to n3, shuffled). Once a robot reaches an unvisited cell it must extract n tokens and store them in the matrix cell.
A supervisor can start/pause the robots (all of them or only a specific one).

The main specifications of the application are:

## Compulsory

- Create an object oriented model of the problem.
- Each robot will have a name and they must perform in a concurrent manner, moving randomly around the map and extracting tokens from the shared memory when reaching an unvisited cell.
- A message will be displayed on the screen every time a robot visits a new cell.
*Simulate the exploration using a thread for each robot.*
- Pay attention to the synchronization of the threads when extracting tokens and when visiting cells.

Pentru a implementa problema, s-a creat un model pentru aceasta, care conține următoarele clase și proprietăți:

- *Token*, o clasă care este utilizată pentru a reprezenta un token, acesta este un element care este plasat de fiecare robot în parte în celulele matricii
- *Cell*, o clasă care modelează celulele matricii explorate de roboți
- *Robot*, o clasă care simulează activitatea de explorare a unui robot
- *SharedMemory*, o clasă utilizată pentru a ține cont de memoria comună pe care o utilizează toți roboții
- *ExplorationMap*, o clasă care conține metode pentru a obține o celulă din matrice nevizitată și pentru a vizita efectiv câte o celulă din matrice
- *Exploration*, o clasă pentru a inițializa un proces de explorare.

## Homework

- Implement the commands that start/pause the robots (all of them or only a specific one). A robot can be paused for a specific time or indefinitely, requiring a start command.
The commands must be given using the keyboard.
- Design an algorithm such that each robots will try to explore the map in a systematic fashion, ensuring the termination of the exploration process.
- Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the exploration and it will stop it exceeds a certain time limit.
- At the end of the exploration, determine how many tokens each robot has placed in the matrix.

La clasa *Exploration*, au fost adăugate metode pentru a porni și opri roboții, pe toți sau doar pe câte unul din ei. Roboții pot fi porniți toți, opriți toți sau câte unul specific. Roboții pot fi puși pe pauză un timp nedefinit sau un număr de secunde limitat.
Comenzile sunt introduse de la tastatură și parsate în aceeași clasă. Când utilizatorul introduce o comandă greșită, este avertizat printr-un warning.
Algoritmul era implementat și în Compulsory - pentru a vizita o nouă celulă, se alege una random din cele care nu au fost deja vizitate. Algorimtul se termină când nu mai rămân celule nevizitate.
S-a adăugat clasa *TimeKeeper*, cu rolul de a ține cont de durata de execuție a algoritmului. Threadul *TimeKeeper* rulează ca daemon și afișează la finalul execuției durata acesteia, dacă timpul nu a fost depășit (în acest caz, doar se va intrerupe procesul.) La final, se afișează și câte token-uri a plasat fiecare robot în matrice.
