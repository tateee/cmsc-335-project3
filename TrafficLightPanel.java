package cmsc335_project3;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class TrafficLightPanel extends JPanel {
    private List<TrafficLight> lights = new ArrayList<>();

    public TrafficLightPanel() {
        setPreferredSize(new Dimension(800, 100));
    }

    // Called when user clicks "Add Intersection"
    public void addIntersection() {
        TrafficLight light = new TrafficLight();
        lights.add(light);
        new Thread(light).start();
        repaint();
    }

    // Paint all traffic lights
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        for (int i = 0; i < lights.size(); i++) {
            TrafficLight light = lights.get(i);
            int x = 50 + i * 150;

            // Draw light label
            g.setColor(Color.BLACK);
            g.drawString("Int " + (i + 1) + ": " + light.getState(), x, 40);

            // Draw color light
            g.setColor(light.getColor());
            g.fillOval(x + 40, 60, 20, 20);
        }
    }

    // Inner class for each independent traffic light
    private class TrafficLight implements Runnable {
        private final String[] states = { "RED", "GREEN", "YELLOW" };
        private int index = 0;

        public String getState() {
            return states[index];
        }

        public Color getColor() {
            switch (states[index]) {
                case "RED": return Color.RED;
                case "GREEN": return Color.GREEN;
                case "YELLOW": return Color.YELLOW;
                default: return Color.BLACK;
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000 + (int)(Math.random() * 2000)); // random cycle duration
                    index = (index + 1) % states.length;
                    repaint(); // triggers panel repaint on update
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

	public void start() {
		
	}

	public void pause() {
		
	}

	public void stop() {
		
	}
}
