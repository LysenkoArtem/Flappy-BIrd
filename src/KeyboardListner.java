import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyboardListner implements KeyListener {
    
    boolean is_pressed = false;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            is_pressed = true;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
