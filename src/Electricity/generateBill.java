package Electricity;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class generateBill extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton btn1,btn2;
    JTextArea t1;
    Choice c1,c2;
    JPanel p1,p2;
    Font f;
    
    generateBill()
    {
        super("Generate Bill");
        setSize(450,700);
        setResizable(false);
        setLocation(20,20);
        
        f = new Font("airel",Font.BOLD,15);
        p1 = new JPanel();
        p2 = new JPanel();
        l1 = new JLabel("Meter No");
        l2 = new JLabel("Month");
        l2.setFont(f);
        l1.setFont(f);
        
        c1 = new Choice();
        c1.add("100");
        c1.add("101");
        c1.add("104");
        c1.add("105");
        c1.add("106");
        c1.add("107");
        c1.add("108");
        
        c1.setFont(f);
        
        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        c2.setFont(f);
        
        t1 = new JTextArea(50,15);
        t1.setFont(f);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/printer.png"));
        Image img1 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        btn1 = new JButton("print",i2);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/email_open.png"));
        Image img2 = i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(img2);
        btn2 = new JButton("show",i4);
        
        btn1.setFont(f);
        btn2.setFont(f);
        
        setLayout(new BorderLayout());
        p1.add(l1);
        p1.add(c1);
        p1.add(l2);
        p1.add(c2);
        
        add(p1,"North");
        p2.add(btn1);
        p2.add(btn2);
        add(p2,"South");
        add(t1);
        
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
         
        
    }
    
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource() == btn2)
        {
            String meterno = c1.getSelectedItem();
            String month = c2.getSelectedItem();
            t1.setText("\tBSMRSTU Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+",2022\n\n");
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q1 = "select * from customer_info where meterno='"+meterno+"'";
                ResultSet rset2 = obj.stm.executeQuery(q1);
                while(rset2.next())
                {
                    t1.append("\nName : "+rset2.getString("name"));
                    t1.append("\nMeter Number : "+rset2.getString("meterno"));
                    t1.append("\nState : "+rset2.getString("state"));
                    t1.append("\nCity : "+rset2.getString("city"));
                    t1.append("\nEmail : "+rset2.getString("email"));
                    t1.append("\nPhone : "+rset2.getString("phone"));
                }
                t1.append("\n-------------------------------------------------");
                    String q2 = "select * from tax";
                    ResultSet rset3 =obj.stm.executeQuery(q2);
                while(rset3.next())
                {
                    t1.append("\nMeter_location: "+rset3.getString("meter_location"));
                    t1.append("\nMeter_Type: "+rset3.getString("meter_type"));
                    t1.append("\nPhase_Code: "+rset3.getString("phase_code"));
                    t1.append("\nBill_Type: "+rset3.getString("bill_type"));
                    t1.append("\nDays: "+rset3.getString("days"));
                    
                    t1.append("\n-------------------------------------------------");
                    t1.append("\nMeter_Rent: "+rset3.getString("meter_rent"));
                    t1.append("\nService_Rent: "+rset3.getString("service_rent"));
                    t1.append("\nVat: "+rset3.getString("vat"));
                }
                t1.append("\n-------------------------------------------------");
                String q = "select * from bills where meter ='"+meterno+"' and month ='"+month+"'";
                ResultSet rset4 = obj.stm.executeQuery(q);
                while(rset4.next())
                {
                   t1.append("\nMeter no : "+rset4.getString("meter"));
                   t1.append("\nCurrent month : "+rset4.getString("month"));
                   t1.append("\nUnits Consumed : "+rset4.getString("units"));
                   t1.append("\n\n--------------------------------------------");
                   t1.append("\nTotal Paybill : "+rset4.getString("amount"));
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        if(ev.getSource() == btn1)
        {
            try
            {
                t1.print();
            }
            catch(Exception exc)
            {
                exc.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) 
    {
        new generateBill().setVisible(true);
    }
}
