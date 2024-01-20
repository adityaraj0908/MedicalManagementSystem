package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Check_My_Profile implements ActionListener
{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
    JButton bt1, bt2;
    
    Check_My_Profile()
    {
        f = new JFrame("My Profile");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,900,450);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/profile.jpg"));
        Image i1= img.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2 = new JLabel("Edit my details");
        l2.setBounds(280, 30, 500, 50);
        l2.setFont(new Font("Airal", Font.BOLD,30));
        l1.setForeground(Color.black);
        
        l1.add(l2);
        f.add(l1);
        
        l3= new JLabel("My ID");
        l3.setBounds(50,150,150,30);
        l3.setFont(new Font("Arial", Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        tf1 = new JTextField();
        tf1.setBounds(200,150,150,30);
        tf1.setEditable(false);
        l1.add(tf1);
        
        l4= new JLabel("Username");
        l4.setBounds(450,150,200,30);
        l4.setFont(new Font("Arial", Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf2 = new JTextField();
        tf2.setBounds(600,150,150,30);
        tf2.setEditable(false);
        l1.add(tf2);
        
        l5= new JLabel("Name");
        l5.setBounds(50,200,100,30);
        l5.setFont(new Font("Arial", Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        tf3 = new JTextField();
        tf3.setBounds(200,200,150,30);
        l1.add(tf3);
        
        l6= new JLabel("Age");
        l6.setBounds(450,200,200,30);
        l6.setFont(new Font("Arial", Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);
        
        tf4 = new JTextField();
        tf4.setBounds(600,200,150,30);
        l1.add(tf4);
        
        l7= new JLabel("Phone");
        l7.setBounds(50,250,100,30);
        l7.setFont(new Font("Arial", Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);
        
        tf5 = new JTextField();
        tf5.setBounds(200,250,150,30);
        l1.add(tf5);
        
        l8= new JLabel("City");
        l8.setBounds(450,250,100,30);
        l8.setFont(new Font("Arial", Font.BOLD,20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);
        
        tf6 = new JTextField();
        tf6.setBounds(600,250,150,30);
        l1.add(tf6);
        
        l9= new JLabel("Email ID");
        l9.setBounds(50,300,100,30);
        l9.setFont(new Font("Arial", Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        l1.add(l9);
        
        tf7 = new JTextField();
        tf7.setBounds(200,300,150,30);
        l1.add(tf7);
        
        l10= new JLabel("Gender");
        l10.setBounds(450,300,100,30);
        l10.setFont(new Font("Arial", Font.BOLD,20));
        l10.setForeground(Color.BLACK);
        l1.add(l10);
        
        tf8 = new JTextField();
        tf8.setBounds(600,300,150,30);
        tf8.setEditable(false);
        l1.add(tf8);
        
        try
        {
            ConnectionClass obj1 = new ConnectionClass();
            String q = "select * from admin";
            ResultSet rest = obj1.stm.executeQuery(q);
            while(rest.next())
            {
                tf1.setText(rest.getString("admin_id"));
                tf2.setText(rest.getString("username"));
                tf3.setText(rest.getString("name"));
                tf4.setText(rest.getString("age"));
                tf5.setText(rest.getString("phone"));
                tf6.setText(rest.getString("city"));
                tf7.setText(rest.getString("email"));
                tf8.setText(rest.getString("gender"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        bt1 = new JButton("Update");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 350, 150, 40);
        l1.add(bt1);
        
        bt2 = new JButton("Cancel");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 350, 150, 40);
        l1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,450);
        f.setLocation(300,100);
        f.setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String ad_id = tf1.getText();
//            String username = tf2.getText();
            String name = tf3.getText();
            String age = tf4.getText();
            String phone = tf5.getText();
            String city = tf6.getText();
            String email = tf7.getText();
//            String gender = tf8.getText();
        try
        {
            ConnectionClass obj2 = new ConnectionClass();
            String q2 = "update admin set name='"+name+"',age='"+age+"',phone='"+phone+"',city='"+city+"',email='"+email+"' where admin_id='"+ad_id+"'";
            obj2.stm.executeUpdate(q2);
            JOptionPane.showMessageDialog(null,"Details Updated!!");
            f.setVisible(false);
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        }
        if(e.getSource()==bt2)
        {
            f.setVisible(false);
        }
    }
    public static void main(String[] args) 
    {
        new Check_My_Profile().setVisible(true);
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
