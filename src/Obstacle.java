import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

class Obstacle {
    int width = 80;

    int top, bottom;

    int x = 800;

    Color color = new Color(60, 175, 0);

    public Obstacle() {
        Random r = new Random();

        top = r.nextInt(80, 300);
        bottom = top + 220;
    }

    public void update() {

        x -= 2;
    }

    public void paint(Graphics2D g) {

        g.setColor(color);
        g.fillRect(x, 0, width, top);

        g.fillRect(x, bottom, width, 600);

        g.setColor(Color.BLACK);
        g.drawRect(x, 0, width, top);

        g.drawRect(x, bottom, width, 600);
    }
}

