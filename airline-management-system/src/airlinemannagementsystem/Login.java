/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemannagementsystem;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author REFAT KHAN
 */
public class Login extends JFrame {
    
    public Login(){
        //frame colour change
        getContentPane().setBackground(Color.yellow);
        //first size increase width second height
        setSize(500,350);
        setLocation(600,250);
          setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
