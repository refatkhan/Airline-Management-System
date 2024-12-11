
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author REFAT KHAN
 */
public class FlightInfo extends JFrame {

    FlightInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(800, 450);
        setLocation(400, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlightInfo();
    }

}
