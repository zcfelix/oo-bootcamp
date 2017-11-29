package ball.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallImpl implements Ball {

    private int x;
    private int y;
    private int radius;
    private List<Behavior> behaviors;

    public BallImpl(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviors = new ArrayList<>();
    }

    public BallImpl(int x, int y) {
        this(x, y, Ball.DEFAULT_RADIUS);
    }


    @Override
    public int radius() {
        return radius;
    }

    @Override
    public Point center() {
        return new Point(x, y);
    }

    @Override
    public void update() {
        behaviors.forEach(x -> x.update(this));
    }

    @Override
    public Ball addBehavior(Behavior behavior) {
        behaviors.add(behavior);
        return this;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
