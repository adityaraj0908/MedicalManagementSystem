package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JPanel panel;
    JLabel l1,l2,l3,l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2;
    int LoginId;
    
    LoginPage(int login_id)
    {
        f=new JFrame("Login Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        
        LoginId = login_id;
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/login_page.jpg"));
        Image i= img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);
        
        l2= new JLabel("Login Page");
        l2.setBounds(198, 30, 500, 50);
        l2.setFont(new Font("Airal", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
        
        l3= new JLabel("Username : ");
        l3.setBounds(135, 120, 150, 30);
        l3.setFont(new Font("Airal", Font.BOLD, 25));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        l4= new JLabel("Password : ");
        l4.setBounds(135, 170, 150, 30);
        l4.setFont(new Font("Airal", Font.BOLD, 25));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf = new JTextField();
        tf.setBounds(310,120,150,30);
        l1.add(tf);
        
        pf=new JPasswordField();
        pf.setBounds(310,170,150,30);
        l1.add(pf);
        
        bt1 = new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(130,220,150,40);
        l1.add(bt1);
        
        bt2 = new JButton("Back");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(310,220,150,40);
        l1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        f.setResizable(false);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String name = tf.getText();
                String pass = pf.getText();
                ResultSet rs;
                if(LoginId==1)
                {
                    String q = "select * from doctor where username ='"+name+"' and password ='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next())
                {
                    String doctorname = rs.getString("name");
                    String doctor_id = rs.getString("doc_id");
                    String doc_username=rs.getString("username");
                    new DoctorHomePage(doctorname,doctor_id,LoginId,doc_username).setVisible(true);
//                    System.out.print("Loged in");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered  wrong Username or Password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
                }
                else if(LoginId==2)
                {
                    String q = "select * from patient where username ='"+name+"' and password ='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next())
                {
                    String patientname = rs.getString("name");
                    String patient_id = rs.getString("patient_id");
                    String pat_username=rs.getString("username");
                    new PatientHomePage(patientname,patient_id,LoginId,pat_username).setVisible(true);
//                    System.out.print("Loged in");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered  wrong Username or Password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
                }
                else if(LoginId==4)
                {
                    String q = "select * from admin where username ='"+name+"' and password ='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next())
                {
                    String adminname = rs.getString("name");
                    String admin_id = rs.getString("admin_id");
                    String admin_username=rs.getString("username");
                    new AdminHomePage(adminname,admin_id,LoginId,admin_username).setVisible(true);
//                    System.out.print("Loged in");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered  wrong Username or Password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
                }
                
                
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(ae.getSource()==bt2)
        {
            this.f.setVisible(false);
            new Index();
        }
    }
//    public static void main(String[] args) {
//        new LoginPage();
//    }
}
