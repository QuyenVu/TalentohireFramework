/*
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseHelper {

    public static ResultSet executeQuery(String DB_URL, String USER_NAME, String PASSWORD, String SQL) throws Throwable {
        ResultSet rs = null;
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            //conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    private static Connection getConnection(String dbURL, String userName,String password) throws Throwable {
        Connection conn = null;
        String dbDriverName = "";//TestConfig.valueFor("dbDriverName");
        try {
            switch(dbDriverName) {
                case "sql":
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    break;
                case "oracle":
                    Class.forName("oracle.jdbc.OracleDriver");
                    break;
                case "mysql":
                    Class.forName("com.mysql.jdbc.Driver");
                    break;
                default:
                    //work out what to do when a browser isn't needed
                    break;
            }
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void main(String args[]) throws Throwable {
        try{
            String url = "jdbc:oracle:thin:@10.50.168.242:1521:TESVM";
            String pass= "TST02";
            String user ="TST02";
            String sql = "SELECT * FROM BILLFEED ";
            ResultSet rs = executeQuery(url,user,pass,sql);
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }catch(Exception e){ System.out.println(e);}

    }

}
*/
