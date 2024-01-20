package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;


public class View_Patient extends JFrame implements ActionListener
{
    String x[]={"Name","Username","Email","Father_Name","Phone","Marital Status","City","Gender","Blood Group","Disease","Age","Adress","DOB"};
    JButton bt, bt1;
    String y[][] = new String[20][13];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    
    View_Patient(String p_username, int login_id)
    {
        super("Patient Information");
        setSize(1500,400);
        setLocation(1,1);
        
        f= new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
           ConnectionClass obj = new ConnectionClass();
           if(login_id==2)
           {
               q = "Select * from patient where username='"+p_username+"'";
           }
           else
           {
               q = "Select * from patient";
           }
           
           ResultSet rest = obj.stm.executeQuery(q);
           while(rest.next())
           {
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("username");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("father_name");
               y[i][j++] = rest.getString("phone");
               y[i][j++] = rest.getString("marital_status");
               y[i][j++] = rest.getString("city");
               y[i][j++] = rest.getString("gender");
               y[i][j++] = rest.getString("blood");
               y[i][j++] = rest.getString("disease");
               y[i][j++] = rest.getString("age");
               y[i][j++] = rest.getString("address");
               y[i][j++] = rest.getString("DOB");
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
        l1 = new JLabel("Patient Username");
        l2 = new JLabel("Edit or Delete any Patient's record");
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l1.setFont(f1);
        l2.setFont(f1);
        
        bt = new JButton("Delete Record");
        bt1 = new JButton("Edit Record");
        bt.addActionListener(this);
        bt1.addActionListener(this);
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
        bt.setForeground(Color.red);
        bt1.setForeground(Color.red);
        
        tf1 = new JTextField();
        tf1.setFont(f);
        
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
        String username = tf1.getText();
        if(ae.getSource()==bt)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill the patient's username !");
            }
            else
            {
                try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q = "delete from patient where username='"+username+"'";
                obj1.stm.executeUpdate(q);
               
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            }
            
        }
        if(ae.getSource()==bt1)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill the patient's Username !");
            }
            else
            {
                setVisible(false);
                new Edit_Patient(username).setVisible(true);
            }
        }
    }
//    public static void main(String[] args) 
//    {
//        new View_Patient().setVisible(true);
//    }
}

