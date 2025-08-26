package cmsc335_project3;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrafficSimulatorFrame().setVisible(true);
        });
    }
}