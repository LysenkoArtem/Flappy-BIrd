import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyboardListner implements KeyListener {
    
    boolean isSpacePressed = false;
    boolean isEscPressed = false;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpacePressed = true;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
           isEscPressed = true; 
        }
	}

}
