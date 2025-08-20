import java.awt.Color;
import java.awt.Graphics2D;

class Bird {
    int x = 120;
    int y = 250;
    int syze = 50;
    
    int fallSpeed = 0;

    Color mainColor = new Color(190, 32, 0);
    Color borderColor = new Color(220, 220, 0);

    public void jump() {
       fallSpeed = -15; 
    }

    public void paint(Graphics2D g) {
        g.setColor(mainColor);
        g.fillOval(x, y, syze, syze);;

        g.setColor(borderColor);
        g.drawOval(x, y, syze, syze);
    }

    public void update() {
        fallSpeed += 1;
        y += fallSpeed;
    }
    
}
