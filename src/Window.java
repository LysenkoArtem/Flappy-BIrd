import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Window extends JPanel implements Runnable{
    int width = 800;
    int height = 600;

    int FPS = 40;


    Thread thread;

    Bird bird = new Bird();

    KeyboardListner kbl = new KeyboardListner();


    public Window() {
        this.setPreferredSize(new Dimension(width, height));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(110, 180, 240));

        this.addKeyListener(kbl);
        this.setFocusable(true);

    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        bird.paint(g2);

    }

    private void update() {
        if (kbl.is_pressed) {
            bird.jump();
            kbl.is_pressed = false;
        }
        bird.update();
    }

	@Override
	public void run() {
        double interval = (double) 1000000000 / FPS;
        double delta = 0;
        long curTime;
        long lastTime = System.nanoTime();

        while (thread != null) {
            curTime = System.nanoTime();

            delta += (curTime - lastTime) / interval;
            lastTime = curTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }

	}

    

}
