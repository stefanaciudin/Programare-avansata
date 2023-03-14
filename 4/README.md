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
