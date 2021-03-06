import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GraphicsTemplate extends JFrame {

    String title = "Graphics Template";
    Color background = Color.BLUE;

    void draw(Graphics2D g2) {
    	final int RAY_COUNT     = 8;
    	final int RADIUS        = 200;
    	final double FULL_ANGLE = 2.0 * Math.PI;
    	final Color COLOR       = Color.RED;
    	
    	int width = getWidth();
    	int height = getHeight();
    	
    	int cx = width / 2;
    	int cy = height / 2;
		double outerradius = RADIUS;
		double innerradius = outerradius * 0.3;
    	double alphaStep = FULL_ANGLE / RAY_COUNT;
    	
    	
    	Color color = COLOR;
    	g2.setColor(color);
    	
    	double alpha = 0;
    	
    	double radius = (RAY_COUNT - 1) % 2 == 0 ? outerradius : innerradius;
    	int previousEndX = (int) (cx + Math.cos(alpha - alphaStep) * radius);
		int previousEndY = (int) (cy + Math.sin(alpha - alphaStep) * radius);
    	
    	
    	for(int ray = 0; ray < RAY_COUNT; ++ray, alpha += alphaStep) {
    		radius = ray % 2 == 0 ? outerradius : innerradius;
    		int endX = (int) (cx + Math.cos(alpha) * radius);
    		int endY = (int) (cy + Math.sin(alpha) * radius);
    		
    		g2.drawLine(cx, cy, endX, endY);
    		g2.drawLine(endX, endY, previousEndX, previousEndY);
    		
    		previousEndX = endX;
    		previousEndY = endY;
    	}

    }
    void drawStar(Graphics2D g2, int x, int y, double innerRadius, double outerRadius, Color color) {
    	int width = getWidth();
    	int height = getHeight();
    	
    	int cx = width / 2;
    	int cy = height / 2;
		double outerradius = RADIUS;
		double innerradius = outerradius * 0.3;
    	double alphaStep = FULL_ANGLE / RAY_COUNT;
    	
    	
    	Color color = COLOR;
    	g2.setColor(color);
    	
    	double alpha = 0;
    	
    	double radius = (RAY_COUNT - 1) % 2 == 0 ? outerradius : innerradius;
    	int previousEndX = (int) (cx + Math.cos(alpha - alphaStep) * radius);
		int previousEndY = (int) (cy + Math.sin(alpha - alphaStep) * radius);
    	
    	
    	for(int ray = 0; ray < RAY_COUNT; ++ray, alpha += alphaStep) {
    		radius = ray % 2 == 0 ? outerradius : innerradius;
    		int endX = (int) (cx + Math.cos(alpha) * radius);
    		int endY = (int) (cy + Math.sin(alpha) * radius);
    		
    		g2.drawLine(cx, cy, endX, endY);
    		g2.drawLine(endX, endY, previousEndX, previousEndY);
    		
    		previousEndX = endX;
    		previousEndY = endY;
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