package homework;

import javax.swing.*;

/**
 * CLass ConfigPanel - models the configuration panel
 * of the application
 */

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel;
    JLabel linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        linesCombo = new JComboBox<>(new Double[]{0.5, 0.4, 0.3, 0.2, 0.1});
        this.frame = frame;
        init();
    }

    void init() {
        // create the label and the spinner
        dotsLabel = new JLabel("Number of dots: ");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));


        // create the rest of the components
        linesLabel = new JLabel("Edge probability: ");
        Double[] probabilities = {0.5, 0.4, 0.3, 0.2, 0.1};
        linesCombo = new JComboBox<>(probabilities);
        createButton = new JButton("Create new game");

        // add the elements
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        createButton.addActionListener(e -> {
            int numVertices = (int) dotsSpinner.getValue();
            double edgeProbability = (double) linesCombo.getSelectedItem();
            frame.createNewGame(numVertices, edgeProbability);
        });


    }
}