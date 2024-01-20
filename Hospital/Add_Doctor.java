package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Add_Doctor implements ActionListener
{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JTextField tf1,tf2,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14;
    JPasswordField pf3;
    JButton bt1, bt2;
    Add_Doctor()
    {
        f = new JFrame("Add Doctor");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,900,600);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/add_doctor_details.jpg"));
        Image i1= img.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2 = new JLabel("Add Doctor Details");
        l2.setBounds(300, 30, 500, 50);
        l2.setFont(new Font("Airal", Font.BOLD,30));
        l1.setForeground(Color.black);
        
        l1.add(l2);
        f.add(l1);
        
        l3= new JLabel("Name");
        l3.setBounds(50,150,150,30);
        l3.setFont(new Font("Arial", Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        tf1 = new JTextField();
        tf1.setBounds(200,150,150,30);
        l1.add(tf1);
        
        l4= new JLabel("Username");
        l4.setBounds(450,150,200,30);
        l4.setFont(new Font("Arial", Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf2 = new JTextField();
        tf2.setBounds(600,150,150,30);
        l1.add(tf2);
        
        l5= new JLabel("Password");
        l5.setBounds(50,200,100,30);
        l5.setFont(new Font("Arial", Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        pf3 = new JPasswordField();
        pf3.setBounds(200,200,150,30);
        l1.add(pf3);
        
        l6= new JLabel("Date Of Birth");
        l6.setBounds(450,200,200,30);
        l6.setFont(new Font("Arial", Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);
        
        tf4 = new JTextField();
        tf4.setBounds(600,200,150,30);
        l1.add(tf4);
        
        l7= new JLabel("Address");
        l7.setBounds(50,250,100,30);
        l7.setFont(new Font("Arial", Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);
        
        tf5 = new JTextField();
        tf5.setBounds(200,250,150,30);
        l1.add(tf5);
        
        l8= new JLabel("Phone");
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
        
        l10= new JLabel("City");
        l10.setBounds(450,300,100,30);
        l10.setFont(new Font("Arial", Font.BOLD,20));
        l10.setForeground(Color.BLACK);
        l1.add(l10);
        
        tf8 = new JTextField();
        tf8.setBounds(600,300,150,30);
        l1.add(tf8);
        
        l11= new JLabel("Gender");
        l11.setBounds(50,350,100,30);
        l11.setFont(new Font("Arial", Font.BOLD,20));
        l11.setForeground(Color.BLACK);
        l1.add(l11);
        
        tf9 = new JTextField();
        tf9.setBounds(200,350,150,30);
        l1.add(tf9);
        
        l12= new JLabel("Blood Group");
        l12.setBounds(450,350,140,30);
        l12.setFont(new Font("Arial", Font.BOLD,20));
        l12.setForeground(Color.BLACK);
        l1.add(l12);
        
        tf10 = new JTextField();
        tf10.setBounds(600,350,150,30);
        l1.add(tf10);
        
        l13= new JLabel("Age");
        l13.setBounds(450,400,100,30);
        l13.setFont(new Font("Arial", Font.BOLD,20));
        l13.setForeground(Color.BLACK);
        l1.add(l13);
        
        tf11 = new JTextField();
        tf11.setBounds(600,400,150,30);
        l1.add(tf11);
        
        l14= new JLabel("Clinic Number");
        l14.setBounds(450,450,150,30);
        l14.setFont(new Font("Arial", Font.BOLD,20));
        l14.setForeground(Color.BLACK);
        l1.add(l14);
        
        tf12 = new JTextField();
        tf12.setBounds(600,450,150,30);
        l1.add(tf12);
        
        l15= new JLabel("Joining Date");
        l15.setBounds(50,400,120,30);
        l15.setFont(new Font("Arial", Font.BOLD,20));
        l15.setForeground(Color.BLACK);
        l1.add(l15);
        
        tf13 = new JTextField();
        tf13.setBounds(200,400,150,30);
        l1.add(tf13);
        
        l16= new JLabel("Specialization");
        l16.setBounds(50,450,140,30);
        l16.setFont(new Font("Arial", Font.BOLD,20));
        l16.setForeground(Color.BLACK);
        l1.add(l16);
        
        tf14 = new JTextField();
        tf14.setBounds(200,450,150,30);
        l1.add(tf14);
        
        bt1 = new JButton("Submit");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 40);
        l1.add(bt1);
        
        bt2 = new JButton("Cancel");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 500, 150, 40);
        l1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);
        f.setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String name = tf1.getText();
            String username = tf2.getText();
            String password = pf3.getText();
            String dob = tf4.getText();
            String address = tf5.getText();
            String phone = tf6.getText();
            String email = tf7.getText();
            String city = tf8.getText();
            String gender = tf9.getText();
            String blood = tf10.getText();
            String age = tf11.getText();
            String clinic = tf12.getText();
            String joining = tf13.getText();
            String splz = tf14.getText();
            String avl = "Yes";
            Random r = new Random();
            String doc_l1 = ""+Math.abs(r.nextInt() % 100000);
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into doctor values('"+doc_l1+"','"+name+"','"+username+"','"+password+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+city+"','"+gender+"','"+blood+"','"+age+"','"+clinic+"','"+joining+"','"+splz+"','"+avl+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            f.setVisible(false);
            
        }
    }
    public static void main(String[] args) 
    {
        new Add_Doctor();
    }
}
