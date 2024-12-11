
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author REFAT KHAN
 */
public class FlightInfo extends JFrame {

    FlightInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JTable table = new JTable();
        try {
            Connect connect = new Connect();

            ResultSet rs = connect.statement("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(800, 450);
        setLocation(400, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlightInfo();
    }

}
