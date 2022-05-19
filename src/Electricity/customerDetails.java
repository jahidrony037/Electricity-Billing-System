package Electricity;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class customerDetails extends JFrame implements ActionListener
{
    int i=0, j=0;
    JTable t1;
    JButton btn1;
    String x[] = {"name","meter number","address","state","city","email","phone"};
    String y[][] = new String [20][8];
    
    
    customerDetails()
    {
         super("Customer Details");
         setBounds(100,100,1200,650);
         setResizable(false);
         
         try
         {
             ConnectionClass obj = new ConnectionClass();
             String q ="select * from customer_info";
             ResultSet res = obj.stm.executeQuery(q);
             while(res.next())
             {
                 y[i][j++]=res.getString("name");
                 y[i][j++]=res.getString("meterno");
                 y[i][j++]=res.getString("address");
                 y[i][j++]=res.getString("state");
                 y[i][j++]=res.getString("city");
                 y[i][j++]=res.getString("email");
                 y[i][j++]=res.getString("phone");
                 
                 i++;
                 j=0;
             }
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
         
         t1 = new JTable(y,x);
         btn1 = new JButton("print");
         add(btn1,"South");
         JScrollPane sp = new JScrollPane(t1);
         add(sp);
         btn1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource() == btn1)
        {
            try
            {
                t1.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
       new customerDetails().setVisible(true);
    }
}
