package cmsc335_project3;


import javax.swing.*;

public class TimerPanel extends JPanel implements Runnable {
    private JLabel timeLabel;
    private Thread thread;
    private boolean running = false;
    private int seconds = 0;

    public TimerPanel() {
        timeLabel = new JLabel("Time: 0");
        add(timeLabel);
    }

    public void start() {
        if (thread == null || !running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void pause() {
        running = false;
    }

    public void stop() {
        running = false;
        seconds = 0;
        timeLabel.setText("Time: 0");
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                seconds++;
                SwingUtilities.invokeLater(() -> timeLabel.setText("Time: " + seconds));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}