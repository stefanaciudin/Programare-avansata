# Laborator 1

## Compulsory
Write a Java application that implements the following operations:
Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
Compute the result obtained after performing the following calculations:
- multiply n by 3;
- add the binary number 10101 to the result;
- add the hexadecimal number FF to the result;
- multiply the result by 6;
Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

Programul afișează mesajul *Hello World*, definește string-ul dat și calculează valoarea lui *n* după cerințe. Programul va calcula cifra de control a numărului *n* și va afișa mesajul *Willy-nilly, this semester I will learn " + languages[result]*, adică textul *Java*.

## Homework
Let n be an integer given as a command line argument. Validate the argument!
Create a n x n Latin Square as a matrix, having as symbols numbers from 1 to n.
For each line, and each column of the matrix, create and display on the screen String objects representing the concatenation of the symbols in the respective line or column.
For larger n display ONLY the running time of the application in nanoseconds or milliseconds. Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
Launch the application from the command line, for example: java Lab1 9.

Programul preia ca argument un număr natural nenul *n*. Pe baza acestui număr natural, se va construi matricea cerută, de dimensiune *n x n*. Liniile acestei matrici sunt completate astfel:
- Prima linie: valorile 1, 2,..., n
- A doua linie: valorile n, 1, 2,..., (n-1) 
...
- Ultima linie: valorile n, (n-1),..., 1
Pentru fiecare linie și coloană, in variabilele de tip String *row* și *column* se vor concatena valorile existente în matrice. Aceste valori vor fi afișate la ecran pentru *n<= 30_000*, altfel se va afișa doar timpul de rulare.

## Bonus
Create the adjacency matrix A of a cycle graph C_n and compute the powers A^2, A^3, ..., A^n. Give an interpretation of the result.

Se va calcula matricea de adiacență *A* în funcție de parametrul *n* primit ca parametru. Matricea este inițializată cu 0, apoi pe fiecare rând al acesteia vor fi prezente câte două valori de 1:
- nodul 0 este vecin cu 1 și n-1
- nodul 1 este vecin cu 0 și 2
...
- nodul n-1 este vecin cu 0 și n-2
Matricea obținută va fi ridicată la puterile 2, 3,..., n și rezultatele vor fi afișate.

Create the adjacency matrix of a regular graph. The number of vertices and the vertex degree are given as arguments.


