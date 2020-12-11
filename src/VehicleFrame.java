import javax.swing.*;
import java.awt.*;

public class VehicleFrame extends JFrame {

    Buttons buttons;
    VehicleView vehicleView;
    // constructor
    public VehicleFrame(String framename, Buttons buttons, VehicleView vehicleView) {
        this.buttons = buttons;
        this.vehicleView = vehicleView;
        initComponents(framename);
    }

    private static final int X = 800;
    private static final int Y = 800;

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(vehicleView);
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
