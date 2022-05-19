
package Electricity;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class LoginPage extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JButton btn1,btn2;
    JPanel p1,p2,p3,p4;
    JPasswordField pf1;
    
     LoginPage()
    {
        super("Login Page for Billing");
        setBounds(250,200,400,210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        l1 = new JLabel("username");
        l2= new JLabel("password");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login1.png"));
        Image img = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        
        l3 = new JLabel(i2);
        tf1 = new JTextField(15);
        pf1 = new JPasswordField(15);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/login_icon.png"));
        Image img2 = i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        btn1 = new JButton("Login",new ImageIcon(img2));
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel_icon.png"));
        Image img3 = i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        btn2 = new JButton("Cancel",new ImageIcon(img3));
        
        Font f = new Font("Arial",Font.BOLD,16);
        l1.setFont(f);
        l2.setFont(f);
        btn1.setFont(f);
        btn2.setFont(f);
        tf1.setFont(f);
        pf1.setFont(f);
        
        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.BLUE);
        
        //panel object ...
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        setLayout(new BorderLayout());
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf1);
        add(p2,BorderLayout.CENTER);
        p1.add(l3);
        add(p1,BorderLayout.WEST);
        p3.add(btn1);
        p3.add(btn2);
        add(p3,BorderLayout.SOUTH);
        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        
    }
    
    public void actionPerformed(ActionEvent ev)
        {
            String name = tf1.getText();
             String pass= pf1.getText();
            try
            {
               //Class.forName("com.mysql.cj.jdbc.Driver");
               //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing?user=root&password=jahidrony1356&useUnicode=true&characterEncoding=UTF-8");
               if(ev.getSource() == btn1)
               {
                   ConnectionClass obj = new ConnectionClass();
                   String q = "select * from logindata where username='"+name+"' and password ='"+pass+"'";
                   Statement stm = obj.cn.createStatement();
                   ResultSet set =stm.executeQuery(q);
                   
                   if(set.next())
                   {
                       new HomePage().setVisible(true);
                       System.out.println("login btn working");
                       this.setVisible(false);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Invalid Login");
                       setVisible(false);
                   }
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Are You Want to Cancel ?");
                   setVisible(false);
               }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    
    public static void main(String[] args)
    {
        new LoginPage().setVisible(true);
    }
    
}
