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
