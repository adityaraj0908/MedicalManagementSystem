package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class View_Appointment extends JFrame implements ActionListener
{
    String x[]={"Appointment_ID","Username","Name","Email","Father_Name","Phone","Marital Status","City","Gender","Blood Group","Age","DOB","Disease","Doctor","Appointment_Date","Appointment_Time","Appointment_Status"};
    JButton bt, bt1;
    String y[][] = new String[20][17];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    
    View_Appointment(String username, int login_id)
    {
        super("Appointment Information");
        setSize(1500,400);
        setLocation(1,1);
        
        f= new Font("MS UI Gothic",Font.BOLD,15);
        
        try
        {
           ConnectionClass obj = new ConnectionClass();
           if(login_id==1)
           {
               q = "Select * from appointment where doctor_username='"+username+"'";
           }
           else if(login_id==2)
           {
               q = "Select * from appointment where patient_username='"+username+"'";
           }
           else if(login_id==4)
           {
               q = "Select * from appointment";
           }
           ResultSet rest = obj.stm.executeQuery(q);
           while(rest.next())
           {
               y[i][j++] = rest.getString("app_id");
               y[i][j++] = rest.getString("patient_username");
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("father_name");
               y[i][j++] = rest.getString("phone");
               y[i][j++] = rest.getString("marital_status");
               y[i][j++] = rest.getString("city");
               y[i][j++] = rest.getString("gender");
               y[i][j++] = rest.getString("blood");
               y[i][j++] = rest.getString("age");
               y[i][j++] = rest.getString("DOB");
               y[i][j++] = rest.getString("disease");
               y[i][j++] = rest.getString("doctor_username");
               y[i][j++] = rest.getString("appointment_date");
               y[i][j++] = rest.getString("appointment_time");
               y[i][j++] = rest.getString("appointment_status");
               i++;
               j=0;
           }
           t= new JTable(y,x);
           t.setFont(f);
           t.setBackground(Color.BLACK);
           t.setForeground(Color.WHITE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        
        f1 =new Font("Lucida Fax", Font.BOLD,25);
        l1 = new JLabel("Appointment ID");
        l2 = new JLabel("Complete or Cancel Appointment");
        l2.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l1.setFont(f1);
        l2.setFont(f1);
        
        tf1 = new JTextField();
        tf1.setFont(f1);
        bt= new JButton("Complete Appointment");
        bt1=new JButton("Cancel Appointment");
        bt.addActionListener(this);
        bt1.addActionListener(this);
        
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
        bt.setForeground(Color.red);
        bt1.setForeground(Color.red);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l1);
        p2.add(tf1);
        p2.add(bt);
        p2.add(bt1);
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        
        
        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p3.setBackground(Color.black);

        
        add(p3,"South");  
        add(sp);
    }
    public void actionPerformed(ActionEvent ae)
    {
       String app_id = tf1.getText();
       if(ae.getSource()==bt)
       {
           if(app_id.isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Please fill the Appointment ID!");
           }
           else
           {
               try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q2 = "update appointment set appointment_status = 'Complete' where app_id='"+app_id+"'";
                int aa = obj1.stm.executeUpdate(q2);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Apppointment is completed!");
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Apppointment ID not found!");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
           }
       }
       if(ae.getSource()==bt1)
       {
           if(app_id.isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Please fill Appointment ID!");
           }
           else
           {
               try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q2 = "update appointment set appointment_status = 'Cancelled' where app_id='"+app_id+"'";
                int aa = obj1.stm.executeUpdate(q2);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Apppointment is cancelled!");
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Apppointment ID not found!");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
           }
       }
    }
//    public static void main(String[] args) 
//    {
//        new View_Appointment().setVisible(true);
//    }
}
