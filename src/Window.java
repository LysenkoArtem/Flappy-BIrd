import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

class Window extends JPanel implements Runnable{
    int width = 800;
    int height = 600;

    int FPS = 40;

    boolean isGameOver = false;
    boolean isGamePaused = false;

    Thread thread;

    Bird bird = new Bird();
    Scoreboard scoreboard = new Scoreboard();

    KeyboardListner kbl = new KeyboardListner();

    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public Window() {
        this.setPreferredSize(new Dimension(width, height));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(110, 180, 240));

        this.addKeyListener(kbl);
        this.setFocusable(true);

        obstacles.add(new Obstacle());

    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    private boolean isCollide(Obstacle obst) {
        if (bird.x+bird.syze >= obst.x && bird.x <= obst.x+obst.width){
            if (bird.y <= obst.top || bird.y+bird.syze >= obst.bottom) {return true;}
        }
        return false;
    }

    private void checkCollision() {
        for (Obstacle obst: obstacles) {
            if (isCollide(obst)) {
                isGameOver = true;
            }
        }
    }

    private boolean isObstaclePassed(Obstacle obst) {
        return (!obst.isPassed && obst.x+obst.width <= bird.x) ;
        
    }

    private void updateObstacles() {
        for (Obstacle obst: obstacles) {
            obst.update();
            if (isObstaclePassed(obst)) {
                scoreboard.scoreUp();
                obst.pass();
            }
        }
        obstacles.removeIf(obst -> obst.x+obst.width < 0);

        if (800 - obstacles.getLast().x >= 300) {obstacles.add(new Obstacle());}
    }
    
    private void paintObstacles(Graphics2D g) {
        
        for (Obstacle obst: obstacles) {
            obst.paint(g);
        }
    }

    private void restart() {
        isGameOver = false;
        isGamePaused = false;
        bird = new Bird();
        obstacles = new ArrayList<>();
        obstacles.add(new Obstacle());
        scoreboard.clearScore();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        paintObstacles(g2);
        bird.paint(g2);
        scoreboard.paint(g2);

    }

    private void update() {
        if (isGameOver){
            if (kbl.isSpacePressed) {
                restart();
                kbl.isSpacePressed = false;
                kbl.isEscPressed = false;

            }
        }
        else if (isGamePaused) {
            if (kbl.isEscPressed) {
                isGamePaused = false;
                kbl.isEscPressed = false;
            }

        }
        else {
            if (kbl.isSpacePressed) {
                bird.jump();
                kbl.isSpacePressed = false;
            }
            if (kbl.isEscPressed) {
                isGamePaused = true;
                kbl.isEscPressed = false;
            }

            bird.update();
            updateObstacles();

            checkCollision();
            if (bird.y > height) {isGameOver = true;}
        }
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
