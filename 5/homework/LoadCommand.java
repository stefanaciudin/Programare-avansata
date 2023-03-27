package homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class LoadCommand - loads a catalog from a given file
 */
public class LoadCommand implements Command {
    String fileName;

    public LoadCommand(String fileName) {
        this.fileName = fileName;
    }

    public void execute() throws InvalidCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readValue(new File(fileName), Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }

    }
}
