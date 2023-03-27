package homework;

import java.io.FileNotFoundException;

/**
 * Interface Command - is implemented by all the created commands
 */
public interface Command {
    void execute() throws InvalidCatalogException, FileNotFoundException;
}
