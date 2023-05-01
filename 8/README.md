# Laborator 8

**JDBC**
Write an application that allows to **connect** to a relational database by using JDBC, **submit** SQL statements and display the results.

The main specifications of the application are:

## Compulsory

- Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
- Write an SQL script that will create the following tables:
  - *albums*: id, release year, title, artist, genre(s)
  - *artists*: id, name (for example: Beatles)
  - *genres*: id, name (for example: Rock)
  - an associative (junction) table in order to store each album genres
- Update pom.xml, in order to add the database driver to the project libraries.
- Create a singleton class in order to manage a connection to the database.
- Create DAO classes that offer methods for managing artists, genres and albums (at least one).
- Implement a simple test using your classes.

A fost creată baza de date *music_library* folosind MySql. S-a creat și un script SQL care creează toate tabelele necesare, și tabela de legătură *album_genres*.
Pentru a controla conexiunea cu baza de date, s-a creat clasa *DatabaseManager*. S-au creat clase DAO - *ArtistDAO*, *GenreDAO*, *AlbumDao* - acestea folosesc obiecte de tip *Artist*, *Genre* și *Album*. Clasa *Test* este utilizată pentru a testa metodele implementate.

## Homework

- Create an object-oriented model of the data managed by the Java application.
- Implement all the DAO classes.
- Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
- Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)

La modelul implementat în **compulsory**, s-a adăugat modificarea conexiunii: se folosește HikariCP. Pentru a importa datele din fișierul *albumlist.csv*, s-a creat clasa *DataImporter*, care este testată în *DataImporterTest*. Baza de date va fi populată cu 500 de albume, și cu artiștii și genurile corespunzătoare acestora.
