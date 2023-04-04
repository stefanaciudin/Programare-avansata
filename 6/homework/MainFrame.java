package homework;

import javax.swing.*;

import java.awt.*;

/**
 * Class MainFrame - represents the main frame of the application
 */
public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super(":sparkles: My Drawing Application :sparkles:");
        init();
    }


    public void createNewGame(int numVertices, double edgeProbability) {
        // update the values of numVertices and edgeProbability in the DrawingPanel
        canvas.setNumVertices(numVertices);
        canvas.setEdgeProbability(edgeProbability);
        // call the createBoard method to redraw the game with the new values
        canvas.createBoard();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER);
        canvas.createBoard();
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);

        //invoke the layout manager
        pack();
    }
}