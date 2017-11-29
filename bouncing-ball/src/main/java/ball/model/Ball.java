package ball.model;

import java.awt.*;

// DO NOT CHANGE (but you can add methods)
public interface Ball {
    int DEFAULT_RADIUS = 50;

    int radius();

    Point center();

    void update();

    Ball addBehavior(Behavior behavior);
}