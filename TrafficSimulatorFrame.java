package cmsc335_project3;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficSimulatorFrame extends JFrame {
    private TimerPanel timerPanel;
    private TrafficLightPanel lightPanel;
    private CarPanel carPanel;

    public TrafficSimulatorFrame() {
        setTitle("Traffic Simulation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timerPanel = new TimerPanel();
        lightPanel = new TrafficLightPanel();
        carPanel = new CarPanel();

        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new BoxLayout(simulationPanel, BoxLayout.Y_AXIS));
        simulationPanel.add(timerPanel);
        simulationPanel.add(lightPanel);
        simulationPanel.add(carPanel);

        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");

        JButton addCarButton = new JButton("Add Car");
        JButton addIntersectionButton = new JButton("Add Intersection");

        startButton.addActionListener(e -> {
            timerPanel.start();
            lightPanel.start();  // starts all existing lights
            carPanel.start();    // starts all existing cars
        });

        pauseButton.addActionListener(e -> {
            timerPanel.pause();
            lightPanel.pause();
            carPanel.pause();
        });

        stopButton.addActionListener(e -> {
            timerPanel.stop();
            lightPanel.stop();
            carPanel.stop();
        });

        addCarButton.addActionListener(e -> carPanel.addCar());
        addIntersectionButton.addActionListener(e -> lightPanel.addIntersection());

        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);
        controlPanel.add(addCarButton);
        controlPanel.add(addIntersectionButton);

        add(simulationPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
}
