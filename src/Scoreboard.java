import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

class Scoreboard {
    int score = 0;

    Font scoreFont = new Font("Arial", Font.BOLD, 24);

    public void scoreUp() {
        score++;
    }

    public void clearScore() {
        score = 0;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(scoreFont);
        g.drawString("Score: "+String.valueOf(score), 10, 20);
    }
}
