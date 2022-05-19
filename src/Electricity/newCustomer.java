package Electricity;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class newCustomer extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton btn1,btn2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
    JPanel p1,p2,p3;
    Font f,f1;
    
    newCustomer()
    {
        super("New Customer Details");
        setBounds(40,50,1000,400);
        setResizable(false);
        
        f=new Font("senserif",Font.BOLD,15);
        f1 = new Font("senserif",Font.BOLD,20);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(9,2,10,10));
        
        l1 = new JLabel("Name");
        tf1 = new JTextField(15);
        l1.setFont(f);
        tf1.setFont(f);
        p1.add(l1);
        p1.add(tf1);
        
        l2 = new JLabel("Meter Number");
        tf2 = new JTextField(15);
        l2.setFont(f);
        tf2.setFont(f);
        p1.add(l2);
        p1.add(tf2);
        
        l3 = new JLabel("Address");
        tf3 = new JTextField(15);
        l3.setFont(f);
        tf3.setFont(f);
        p1.add(l3);
        p1.add(tf3);
        
        l4 = new JLabel("State");
        tf4 = new JTextField(15);
        l4.setFont(f);
        tf4.setFont(f);
        p1.add(l4);
        p1.add(tf4);
        
        l5 = new JLabel("City");
        tf5 = new JTextField(15);
        l5.setFont(f);
        tf5.setFont(f);
        p1.add(l5);
        p1.add(tf5);
        
        l6 = new JLabel("Email");
        tf6 = new JTextField(15);
        l6.setFont(f);
        tf6.setFont(f);
        p1.add(l6);
        p1.add(tf6);
        
        l7 = new JLabel("Phone no");
        tf7 = new JTextField(15);
        l7.setFont(f);
        tf7.setFont(f);
        p1.add(l7);
        p1.add(tf7);
        
        l9 = new JLabel("New Customer Details");
        l9.setFont(f1);
        l9.setHorizontalAlignment(JLabel.CENTER);
        l9.setForeground(Color.BLUE);
        
        btn1 = new JButton("Submit");
        btn2 = new JButton("Cancel");
        
        btn1.setFont(f);
        btn2.setFont(f);
       // p1.add(btn1);
       // p1.add(btn2);
        //p1.setBackground(Color.cyan);
       
        
       btn1.setBackground(Color.BLACK);
       btn1.setForeground(Color.WHITE);
       btn2.setBackground(Color.BLACK);
       btn2.setForeground(Color.WHITE);
       
       p3 = new JPanel();
       p3.add(btn1);
       p3.add(btn2);
       p3.setLayout(new GridLayout(1,2,50,50));
       p1.add(p3);
        
       p2 = new JPanel();
       p2.setLayout(new GridLayout(1,1));
       
       ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/newCustomer.jpg"));
       Image image = img.getImage().getScaledInstance(270, 270, Image.SCALE_DEFAULT);
       ImageIcon img2 = new ImageIcon(image);
       l8 = new JLabel(img2);
       p2.add(l8);
       
      
       
       setLayout(new BorderLayout(30,30));
       
       add(l9,"North");
       add(p1,"Center");
       add(p2,"West");
       //add(p3,"South");
       
       btn1.addActionListener(this);
       btn2.addActionListener(this);
       
        
    }
    
    public void actionPerformed(ActionEvent ev)
    {
        try
        {
            if(ev.getSource()== btn1)
            {
                
                String name = tf1.getText();
                String meterno = tf2.getText();
                String address = tf3.getText();
                String state = tf4.getText();
                String city = tf5.getText();
                String email = tf6.getText();
                String phone = tf7.getText();
                
                try
                {
                    ConnectionClass obj = new ConnectionClass();
                    String q ="insert into customer_info values('"+name+"','"+meterno+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
                    obj.stm.executeUpdate(q);
                }   
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(null, "Employe data inserted!");
                setVisible(false);
            }
            if(ev.getSource() == btn2)
            {
                System.exit(0);
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new newCustomer().setVisible(true);
    }
}
