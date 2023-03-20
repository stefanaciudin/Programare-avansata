package compulsory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Catalog - has a name and an array of documents.
 * Has a method load that loads a specific catalog from a specified file
 * using ObjectInputStream
 */

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    // constructors
    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    // function that loads a catalog from a file
    public static Catalog load(String file) throws ClassNotFoundException, InvalidCatalogException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Catalog) in.readObject();
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }

    // function to add a file/document to a list of documents
    public void add(Document doc) {
        docs.add(doc);
    }

    public List<Document> getDocs() {
        return docs;
    }

    public String getName() {
        return name;
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }


}