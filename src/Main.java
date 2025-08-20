import javax.swing.JFrame;

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");

        frame.add(new Window());


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
