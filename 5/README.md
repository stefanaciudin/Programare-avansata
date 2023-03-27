# Laborator 5

Document Management System
Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.

The main specifications of the application are:

## Compulsory

Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. Create a class responsible with external operations regarding a catalog.
Implement the following methods representing commands that will manage the content of the catalog:

- *add*: adds a new entry into the catalog;
- *toString*: a textual representation of the catalog;
- *save*: saves the catalog to an external file using JSON format; you may use Jackson or other library;
- *load*: loads the catalog from an external file.

Au fost implementate întâi clasele *Catalog* și *Document* pentru a oferi informații despre un document (numele, locația lui, id-ul) și despre un catalog. Clasa *CatalogManager* conține metodele cerute:

- *add*: adaugă un nou document la catalog
- *toString*: afișează informații despre un catalog
- *save*: salvează un catalog într-un fișier oferit ca parametru în formatul JSON
- *load*: încarcă un catalog dintr-un fișier extern, oferit ca parametru.

În clasa *Main*, se testează toate metodele implementate.

## Homework

Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.
Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).

- *list*: prints the list of documents on the screen
- *view*: opens a document using the native operating system application (see the Desktop class);
- *report*: creates (and opens) an HTML report representing the content of the catalog. Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
The application will signal invalid data or the commands that are not valid using custom exceptions.
The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

S-a creat interfața *Command*, care este implementată de fiecare tip de comandă în parte. Aceasta conține metoda *execute*, care este implementată pentru fiecare comandă cu un comportament specific. S-au creat clase pentru fiecare tip de comandă, atât pentru cele implementate în **Compulsory**, cât și pentru cele din **Homework**.
A fost generat și un fișier .jar pentru aplicație - acesta poate fi rulat de la linia de comandă pentru a obține rezutatul dorit.

## Bonus

:)
