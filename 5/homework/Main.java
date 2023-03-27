package homework;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class used to test the methods and classes implemented
 */

public class Main {
    public static void main(String[] args) throws InvalidCatalogException, FileNotFoundException {
        Catalog catalog = new Catalog("My Catalog");

        // create objects
        Document doc1 = new Document("1", "article1.txt", "/home/stef/Desktop/pa labs/5/homework/article1.txt");
        doc1.addTag("author", "Author1");
        doc1.addTag("year", "2021");
        doc1.addTag("category", "Science");

        Document doc2 = new Document("2", "book1.txt", "/home/stef/Desktop/pa labs/5/homework/book1.txt");
        doc2.addTag("author", "Author2");
        doc2.addTag("year", "2020");
        doc2.addTag("category", "Literature");

        Document doc3 = new Document("3", "book2.txt", "/home/stef/Desktop/pa labs/5/homework/book2.txt");
        doc3.addTag("author", "Jesus");
        doc3.addTag("year", "1");
        doc3.addTag("category", "holy bible");


        // create commands
        String path = new File("catalog.json").getAbsolutePath();
        Command addCommand = new AddCommand(catalog, new Document[]{doc1, doc2});
        Command listCommand = new ListCommand(catalog);
        Command viewCommand = new ViewCommand(doc1);
        Command reportCommand = new ReportCommand(catalog, "../homework/catalog.html");
        Command saveCommand = new SaveCommand(catalog, path);
        Command loadCommand = new LoadCommand(path);

        // and executing them
        addCommand.execute();
        //saveCommand.execute();
        listCommand.execute();
        //viewCommand.execute();
        reportCommand.execute();
        //loadCommand.execute();
    }
}