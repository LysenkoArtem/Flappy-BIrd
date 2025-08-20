import javax.swing.JFrame;

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");

        Window window = new Window();
        frame.add(window);

        window.startThread();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
