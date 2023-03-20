package compulsory;

/**
 * Class used to test the methods implemented
 */
public class Main {
    public static void main(String[] args) throws InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("1","article1.txt","/home/stef/Desktop/pa labs/5/compulsory" );
        var article = new Document("2","book1.txt","/home/stef/Desktop/pa labs/5/compulsory" );
        catalog.add(book);
        catalog.add(article);

        CatalogManager.save(catalog, "/home/stef/Desktop/pa labs/5/compulsory/catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogManager.load("/home/stef/Desktop/pa labs/5/compulsory/catalog.json");
        System.out.println(catalog);
        //CatalogManager.view(catalog.findById("article1"));
    }
}