
package Electricity;
import java.sql.*;

public class ConnectionClass {
    Connection cn;
    Statement stm;
   public ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing?user=root&password=jahidrony1356&useUnicode=true&characterEncoding=UTF-8");
            stm=cn.createStatement();
//            if(cn.isClosed())
//            {
//                System.out.println("system closed");
//            }
//            else
//            {
//                System.out.println("system open");
//            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
