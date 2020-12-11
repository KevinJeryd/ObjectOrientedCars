import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleView extends JFrame implements VehicleObserver {

    Buttons buttons;
    // constructor
    public VehicleView(String framename, Buttons buttons) {
        this.buttons = buttons;
        initComponents(framename);
    }

    public void actOnUpdate(Vehicle vehicle) {
        drawPanel.repaint();
    }

    private static final int X = 800;
    private static final int Y = 800;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);



    @Override
    public int getPanelHeight() {
        return drawPanel.getHeight();
    }

    public int getPanelWidth() {
        return drawPanel.getWidth();
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add(buttons.gasPanel);
        this.add(buttons.controlPanel);
        this.add(buttons.startButton);
        this.add(buttons.stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
