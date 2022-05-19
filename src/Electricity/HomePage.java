package Electricity;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HomePage extends JFrame implements ActionListener {
    JLabel l1;
     HomePage()
    {
        //title
        super("Electricity Billing System");
        
        setSize(1600,690);
        
        //screen background image set.....
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("image/background.jpg"));
        Image i3 = i2.getImage().getScaledInstance(1600, 690, Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(i3);
        l1 = new JLabel(icc);
        add(l1);
        
        //menubar set 
        //First Column
        JMenuBar mb = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem mi1 = new JMenuItem("New Customer");
        JMenuItem mi2 = new JMenuItem("Customer Details");
        
        master.setForeground(Color.BLUE);
        
        //NewCustomer details
        
        Font f = new Font("monospaced",Font.PLAIN,16);
        mi1.setFont(f);
        ImageIcon img_mi1=new ImageIcon(ClassLoader.getSystemResource("icon/new_customer.png"));
        Image image_mi1 = img_mi1.getImage().getScaledInstance(16, 20, Image.SCALE_DEFAULT);
        mi1.setIcon(new ImageIcon(image_mi1));
        
        mi1.setMnemonic('D');
        mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        mi1.setBackground(Color.white);
        
        //Customer Details 
        
        mi2.setFont(f);
        ImageIcon img_mi2=new ImageIcon(ClassLoader.getSystemResource("icon/customer_details.png"));
        Image image_mi2 = img_mi2.getImage().getScaledInstance(16, 20, Image.SCALE_DEFAULT);
        mi2.setIcon(new ImageIcon(image_mi2));
        
        mi2.setMnemonic('M');
        mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        mi2.setBackground(Color.white);
        
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        
        //second Cloumn
        
        JMenu user = new JMenu("User");
        JMenuItem ui1 = new JMenuItem("Pay Bill");
        //JMenuItem ui2 = new JMenuItem("Calculate Bill");
        //JMenuItem ui3 = new JMenuItem("Last Bill);
        
        //pay bill details..............
        ui1.setFont(f);
        ImageIcon img_ui1 = new ImageIcon(ClassLoader.getSystemResource("icon/generate_bill.png"));
        Image image_ui1 = img_ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ui1.setIcon(new ImageIcon(image_ui1));
        ui1.setMnemonic('F');
        ui1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        ui1.setBackground(Color.WHITE);
        
        ui1.addActionListener(this);
        
        
        //third Column
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        
        //Generate Bill Details
        r1.setFont((f));
        ImageIcon img_r1 = new ImageIcon(ClassLoader.getSystemResource("icon/generate_bill.png"));
        Image image_r1 = img_ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image_r1));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        //forth column
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        
        ex.setFont(f);
        ImageIcon img_ex = new ImageIcon(ClassLoader.getSystemResource("icon/cancel_icon.png"));
        Image image_ex = img_ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image_ex));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
         
        //add menu....
        
        master.add(mi1);
        master.add(mi2);
        
        user.add(ui1);
        
        report.add(r1);
        
        exit.add(ex);
        
        mb.add(master);
        mb.add(user);
        mb.add(report);
        mb.add(exit);
        
        setJMenuBar(mb);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        
        
       
         
        
    }
     
     public void actionPerformed(ActionEvent ev)
     {
         String msg = ev.getActionCommand();
         if(msg.equals("New Customer"))
         {
             new newCustomer().setVisible(true);
         }
         
         else if(msg.equals("Customer Details"))
         {
             new customerDetails().setVisible(true);
         }
         
         else if(msg.equals("Pay Bill"))
         {
             new payBill().setVisible(true);
         }
         else if(msg.equals("Generate Bill"))
         {
             new generateBill().setVisible(true);
         }
         else if(msg.equals("Exit"))
         {
             System.exit(0);
         }
         else
         {
             System.out.println("Wrong");
         }
         
     }
    public static void main(String[] args) {
       new HomePage().setVisible(true);
       
    }
}
