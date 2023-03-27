package homework;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Class ViewCommand - shows the document's location using the native OS system application
 */
public class ViewCommand implements Command {
    private final Document document;

    public ViewCommand(Document doc) {
        document = doc;
    }

    public void execute() {
        String path = document.getLocation();
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            System.out.println("Error opening document " + e.getMessage());
        }
    }
}
