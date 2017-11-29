import ball.model.BallFactory;
import ui.BallWorld;

import javax.swing.*;

public class BallApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Ball World");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(
                    new BallWorld(BallFactory.all())
            );
            frame.pack();
            frame.setVisible(true);
        });
    }
}
