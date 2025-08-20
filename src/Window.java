import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

class Window extends JPanel {
    int width = 800;
    int height = 600;

    public Window() {
        this.setPreferredSize(new Dimension(width, height));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(110, 180, 240));
    }

}
