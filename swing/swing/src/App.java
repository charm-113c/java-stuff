import javax.swing.BorderFactory;

// import java.awt.BorderLayout;
// import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("sx");

        jFrame.setSize(640, 400);
        jFrame.add(new JPanel(new BorderLayout()) {
            // Initialization instruction block
            {
                setBackground(Color.GREEN);
                add(new JPanel() {
                    {
                        setBackground(Color.BLUE);
                        // setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                        // JButton gioca = new JButton("Gioca");
                        // gioca.addActionListener;
                        // JButton profile = new JButton("Profilo");

                        // add(gioca);
                        // add(profile);
                        add(new JPanel() {
                            {
                                setBackground(Color.YELLOW);
                            }
                        }, BorderLayout.CENTER);
                    }
                }, BorderLayout.CENTER);
            }
        });
    }
}
