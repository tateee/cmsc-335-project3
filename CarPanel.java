package cmsc335_project3;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CarPanel extends JPanel {
    private List<Car> cars = new ArrayList<>();

    public CarPanel() {
        setPreferredSize(new Dimension(800, 100));
    }

    public void addCar() {
        Car car = new Car();
        cars.add(car);
        new Thread(car).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Car car : cars) {
            g.fillRect(car.getX(), 20, 50, 30);
        }
    }

    private class Car implements Runnable {
        private int x = 0;
        private int speed = 10;
        private boolean running = true;

        public int getX() { return x; }

        public void run() {
            while (running) {
                try {
                    Thread.sleep(1000);
                    x += speed;
                    if (x > getWidth()) x = 0;
                    repaint();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
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
