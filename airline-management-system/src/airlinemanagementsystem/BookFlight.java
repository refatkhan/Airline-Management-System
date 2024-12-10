package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfName, tfnationality, tflNid, tfAdress, tfPhone;
    JRadioButton rbmale, rbfemale;

    public BookFlight() {

        getContentPane().setBackground(Color.gray);
        setLayout(null);
        // heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);
        // we will search data by nid
        JLabel lblNid = new JLabel("NID: ");
        lblNid.setBounds(60, 80, 150, 25);
        lblNid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNid);

        // fetchButton
        JButton fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380, 80, 120, 25);
        add(fetchButton);

        // textfield for Nid
        tflNid = new JTextField();
        tflNid.setBounds(220, 80, 150, 25);
        add(tflNid);
        // lavelname
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 80, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        // textfield for name
        tfName = new JTextField();
        tfName.setBounds(220, 80, 150, 25);
        add(tfName);

        // // lavel for nationality
        JLabel lblnationality = new JLabel("Nationality: ");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        // textfield for Nationality
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);

        // address
        JLabel lblAddress = new JLabel("Adress: ");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        tfAdress = new JTextField();
        tfAdress.setBounds(220, 230, 150, 25);
        add(tfAdress);

        // use this for select any option between male and female
        ButtonGroup gendergGroup = new ButtonGroup();
        // radio button
        JLabel lblGender = new JLabel("Gender: ");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        gendergGroup.add(rbfemale);
        gendergGroup.add(rbmale);

        JLabel lblPhone = new JLabel("Phone: ");
        lblPhone.setBounds(60, 330, 150, 25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);
        tfPhone = new JTextField();
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);

        JButton save = new JButton("Saved");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);

        ImageIcon imageIcon = new ImageIcon();
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(imageIcon);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfName.getText();
        String nationality = tfnationality.getText();
        String phone = tfPhone.getText();
        String nid = tflNid.getText();
        String address = tfAdress.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        try {
            Connect connect = new Connect();
            String query = "insert into passenger values('" + name + "', '" + nationality + "', '" + phone + "', '"
                    + address + "', '" + nid + "', '" + gender + "')";
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details added succesfull");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new BookFlight();
    }
}