import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingRectangle extends JFrame {
    private int[] xPoints = {20, 300, 250, 50};
    private int[] yPoints = {260, 260, 340, 340};
    private int nPoints = 4;

    public MovingRectangle() {
        setTitle("Scenario With Moving Boat");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a JPanel to the frame
        MovingRectanglePanel panel = new MovingRectanglePanel();
        add(panel);

        // Set up a timer to update the position of the rectangle
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update x-coordinates to move the rectangle to the right
                for (int i = 0; i < nPoints; i++) {
                    xPoints[i] += 1;
                }

                // Repaint the panel to show the updated position
                panel.repaint();

                // Stop the timer when the rectangle reaches the right edge
                if (xPoints[2] > getWidth()) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        // Start the timer
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new MovingRectangle();
    }

    class MovingRectanglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

        g.setColor(Color.GREEN);

        // Draw a filled green rectangle
        g.fillRect(0, 250, 1920, 640);
        
        System.setProperty("myColor", "0X4d8fd6");
        g.setColor(Color.getColor("myColor"));
        
        g.fillRect(0, 0, 1920, 440);
        
        System.setProperty("myColor2", "0Xf0f5fa");
        g.setColor(Color.getColor("myColor2"));
        
        g.fillRoundRect(1120, 30, 150, 150, 200, 200);
        
        g.setColor(Color.BLACK);

        // Draw a filled green rectangle
        g.fillRect(0, 500, 1920, 250);
        
        
        g.setColor(Color.ORANGE);

        // Draw a filled green rectangle
        g.fillRect(0, 615, 1920, 20);
            // Set color to green for the filled rectangle
        g.setColor(Color.RED);

            // Draw the filled rectangle using fillPolygon
        g.fillPolygon(xPoints, yPoints, nPoints);
        
        g.setColor(Color.WHITE);

        // Draw a filled green rectangle
        g.fillRect(600, 600, 5, 250);
        
        g.setColor(Color.RED);
        
        g.fillRoundRect(550, 570, 110, 110, 150, 150);
            
        }
    }
}
