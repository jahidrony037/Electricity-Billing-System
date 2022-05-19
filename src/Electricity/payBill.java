package Electricity;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class payBill extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JButton btn1, btn2;
    JTextArea t1;
    Choice c1,c2;
    JPanel p1,p2;
    Font f,f1;
    payBill()
    {
        super("Pay Bill");
        setBounds(200,200,1000,400);
        setResizable(false);
        
        f = new Font("senserif",Font.BOLD,15);
        f1 = new Font("senserif",Font.BOLD,18);
        l1 = new JLabel("Meter No");
        l2 = new JLabel("Month");
        l3 = new JLabel("Units Consumbed");
        l5 = new JLabel("Calculate Electricity Bill");
        l5.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l5.setFont(f1);
        
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
        
        t1 = new JTextArea();
        t1.setFont(f);
        
        btn1 = new JButton("Submit");
        btn2 = new JButton("Cancel");
        
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        
        btn1.setFont(f);
        btn2.setFont(f);
        
        btn1.setSize(50,50);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(4,2,30,30));
        p1.add(l1);
        p1.add(c1);
        p1.add(l2);
        p1.add(c2);
        p1.add(l3);
        p1.add(t1);
        p1.add(btn1);
        p1.add(btn2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        ImageIcon imgl = new ImageIcon(ClassLoader.getSystemResource("image/bill.png"));
        Image img = imgl.getImage().getScaledInstance(270, 270, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img);
        l4 = new JLabel(img2);
        p2.add(l4);
        
        setLayout(new BorderLayout(30,30));
        //setLayout(new GridLayout(1,2,1,1));
        add(l5,"North");
        add(p1,"Center");
        add(p2,"West");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
          
        
    }
    double totalBill,bill,charge,vat,meter_rent=40.00;
    private double calculateBill(double x)
    {
        if(x>=1 && x<=50)
        {
            bill = (x*3.36);
            vat = bill * 0.5;
            charge = 10.00 + 15.00;
            totalBill = bill + vat + charge + meter_rent;
        }
        else if(x>=1 && x<=75)
        {
            bill = (x*3.80);
            vat = bill * 0.5;
            charge = 10.00 + 15.00;
            totalBill = bill + vat + charge + meter_rent;
        }
        else if(x>=76 && x<=200)
        {
            bill = (x*5.14);
            vat = bill * 0.5;
            charge = 10.00 + 15.00;
            totalBill = bill + vat + charge + meter_rent;
        }
        else if(x>=201 && x<=300)
        {
            bill = (x*5.36);
            vat = bill * 0.5;
            charge = 10.00 + 15.00;
            totalBill = bill + vat + charge + meter_rent;
        }
        else
        {
            bill = (x*8.70);
            vat = bill * 0.5;
            charge = 10.00 + 15.00;
            totalBill = bill + vat + charge + meter_rent;
        }
        return totalBill;
    }
    
    
    public void actionPerformed(ActionEvent ev)
    {
        
        if(ev.getSource() == btn1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String meter = c1.getSelectedItem();
                String month = c2.getSelectedItem();
                
                double units = Double.parseDouble(t1.getText());
                payBill bill = new payBill();
                double amount = bill.calculateBill(units);
                String q ="insert into bills values('"+meter+"','"+month+"','"+units+"','"+amount+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data Successfully inserted...");
                //System.out.println("submit btn working");
                setVisible(false); 
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(ev.getSource() == btn2)
        {
            JOptionPane.showMessageDialog(null, "Are You Sure ?");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new payBill().setVisible(true);
    }
    
}
