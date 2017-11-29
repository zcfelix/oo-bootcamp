package ui;

import ball.model.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class BallWorld extends JPanel {
    public final static int BOX_WIDTH = 640;
    public final static int BOX_HEIGHT = 480;

    private static final int REFRESH_RATE_PER_SECOND = 30;

    private final Ball[] balls;

    public BallWorld(Ball... balls) {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        this.balls = balls;

        Thread displayThread = new Thread(() -> {
            while (true) {
                updateBalls();
                repaint();  // Callback paintComponent
                try {
                    Thread.sleep(1000 / REFRESH_RATE_PER_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        displayThread.start();
    }

    private void updateBalls() {
        Stream.of(balls).forEach(Ball::update);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
        Stream.of(balls).forEach(ball -> paintBall(ball, graphics));
    }

    private void paintBall(Ball ball, Graphics graphics) {
        Point center = ball.center();
        Point upperLeftCoordinate = new Point(center.x - ball.radius(), center.y - ball.radius());
        int diameter = 2 * ball.radius();

        graphics.setColor(Color.GREEN);
        graphics.fillOval(upperLeftCoordinate.x, upperLeftCoordinate.y, diameter, diameter);
    }
}
