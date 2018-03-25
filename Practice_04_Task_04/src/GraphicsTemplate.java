import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GraphicsTemplate extends JFrame {

    String title = "Graphics Template";
    Color background = Color.BLACK;

    void draw(Graphics2D g2) {
    	final int CIRCLE_COUNT = 100_000;
    	
    	final int RADIUS_MIN = 1;
    	final int RADIUS_MAX = 10;
    	
    	final int RED_MIN = 0;
    	final int RED_MAX = 255;
    	final int GREEN_MIN = 0;
    	final int GREEN_MAX = 255;
    	final int BLUE_MIN = 0;
    	final int BLUE_MAX = 255;
    	
    	int width = getWidth();
    	int height = getHeight();
    	
    	for (int i = 0; i < CIRCLE_COUNT; ++i) {
    	    int radius = (int) (RADIUS_MIN + Math.random() * (RADIUS_MAX - RADIUS_MIN + 1));
        	int diameter = 2 * radius;
        	
        	int x = (int) (- radius + Math.random() * (width + radius + 1));
        	int y = (int) (- radius + Math.random() * (height + radius + 1));
        	
        	int red = (int) (RED_MIN + Math.random() * (RED_MAX - RED_MIN + 1));;
        	int green = (int) (GREEN_MIN + Math.random() * (GREEN_MAX - GREEN_MIN + 1));;
        	int blue = (int) (BLUE_MIN + Math.random() * (BLUE_MAX - BLUE_MIN + 1));;

        	g2.setColor(new Color(red, green, blue));
            g2.fillOval(x, y, diameter, diameter);
            
            repaint();
            try {
            	Thread.sleep(13);
            } catch(InterruptedException e) {
            	e.print 
            }
    	}
    	
    }

    public GraphicsTemplate() {
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DrawPanel panel = new DrawPanel();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GraphicsTemplate();
    }

    class DrawPanel extends JPanel {
        public DrawPanel() {
            setBackground(background);
            setFocusable(true);
            requestFocusInWindow();
            setDoubleBuffered(true);
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2.setRenderingHints(hints);

            super.paintComponent(g);
            draw(g2);
        }
    }

}

