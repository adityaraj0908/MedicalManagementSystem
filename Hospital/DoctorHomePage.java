package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DoctorHomePage extends JFrame implements ActionListener 
{
    JLabel l1;
    Font f,f1,f2;
    public String doctor_id2;
    int login__id;
    String username2;
    String doctorid2;
    
    DoctorHomePage(String doctorname,String doctor_id, int login_id,String username)
    {
        super("Doctor Home Page");
        setLocation(0,0);
        setSize(1500,730);
        
        doctor_id2=doctor_id;
        login__id=login_id;
        username2=username;
        doctorid2=doctor_id;
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/doctor_homepage.jpg"));
        Image img= ic.getImage().getScaledInstance(1500,730,Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        l1=new JLabel(ic1);
        
        f= new Font("Lucida Fax", Font.BOLD, 20);
        f2= new Font("Gadugi", Font.BOLD, 35);
        f1= new Font("MS UI Gothic", Font.BOLD, 18);
        
        JMenuBar m1 = new JMenuBar();

        JMenu men1 = new JMenu("Doctor");
//        JMenuItem men1t1 = new JMenuItem("Add Doctor");
        JMenuItem men1t2 = new JMenuItem("View Doctor");
        
        JMenu men2 = new JMenu("Patient");
//        JMenuItem men2t1 = new JMenuItem("Add Patient");
        JMenuItem men2t2 = new JMenuItem("View Patient");
        
//        JMenu men3 = new JMenu("Receptionist");
//        JMenuItem men3t1 = new JMenuItem("Add Receptionist");
//        JMenuItem men3t2 = new JMenuItem("View Receptionist");
        
        JMenu men4 = new JMenu("Appointment");
//        JMenuItem men4t1 = new JMenuItem("Add Appointment");
        JMenuItem men4t2 = new JMenuItem("View Appointment");
        
        JMenu men5 = new JMenu("Hi Doctor("+doctorname+")");
//        JMenuItem men5t1 = new JMenuItem("My Profile");
//        JMenuItem men5t2 = new JMenuItem("Change Password");
        
        JMenu men6 = new JMenu("Exit");
        JMenuItem men6t1 = new JMenuItem("Exit");
        
//        men1.add(men1t1);
        men1.add(men1t2);
//        men2.add(men2t1);
        men2.add(men2t2);
//        men3.add(men3t1);
//        men3.add(men3t2);
//        men4.add(men4t1);
        men4.add(men4t2);
//        men5.add(men5t1);
//        men5.add(men5t2);
        men6.add(men6t1);
        
        m1.add(men1);
        m1.add(men2);
//        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        
        men1.setFont(f);
        men2.setFont(f);
//        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        
//        men1t1.setFont(f1);
        men1t2.setFont(f1);
//        men2t1.setFont(f1);
        men2t2.setFont(f1);
//        men3t1.setFont(f1);
//        men3t2.setFont(f1);
//        men4t1.setFont(f1);
        men4t2.setFont(f1);
//        men5t1.setFont(f1);
//        men5t2.setFont(f1);
        men6t1.setFont(f1);
        
        m1.setBackground(Color.BLACK);
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
//        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.RED);
        
//        men1t1.setForeground(Color.YELLOW);
//        men2t1.setForeground(Color.YELLOW);
//        men3t1.setForeground(Color.YELLOW);
//        men4t1.setForeground(Color.YELLOW);
//        men5t1.setForeground(Color.YELLOW);
        men6t1.setForeground(Color.RED);
        
//        men1t1.setBackground(Color.BLACK);
//        men2t1.setBackground(Color.BLACK);
//        men3t1.setBackground(Color.BLACK);
//        men4t1.setBackground(Color.BLACK);
//        men5t1.setBackground(Color.BLACK);
        men6t1.setBackground(Color.BLACK);
        
//        men1t1.addActionListener(this);
        men1t2.addActionListener(this);
//        men2t1.addActionListener(this);
        men2t2.addActionListener(this);
//        men3t1.addActionListener(this);
//        men3t2.addActionListener(this);
//        men4t1.addActionListener(this);
        men4t2.addActionListener(this);
//        men5t1.addActionListener(this);
//        men5t2.addActionListener(this);
        men6t1.addActionListener(this);
        

        setJMenuBar(m1);
        add(l1);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String comnd = ae.getActionCommand();
        if(comnd.equals("View Doctor"))
        {
              new View_Doctor(login__id).setVisible(true);  
        }
        
        if(comnd.equals("Exit"))
        {
            this.setVisible(false);
            new Index();
        }
        else if(comnd.equals("View Patient"))
        {
              new View_Patient(username2,login__id).setVisible(true);  
        }
        else if(comnd.equals("View Appointment"))
        {
            new View_Appointment(username2,login__id).setVisible(true);
        }
//        else if(comnd.equals("My Profile"))
//        {
//            new Check_My_Profile(doctorid2,login__id);
//        }
        
        
        
    }
}
