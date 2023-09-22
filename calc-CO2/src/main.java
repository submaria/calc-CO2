import javax.swing.SwingUtilities;

public class main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new APS().setVisible(true);
            }
        });
    }
}
