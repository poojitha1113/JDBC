import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete_entry {
    public static void main(String[]args)
    {

       try {
           //1.load and registre the driver
           DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
           //2.connection
           String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";

           String user="sa";
           String pass="jdbc";
           Connection connectionobj=DriverManager.getConnection(url,user,pass);

           //create sql quarry

           String sql="delete  leave where EmployeeId=103";
           //execute and create platform
           Statement statementobj=connectionobj.createStatement();
           int result=statementobj.executeUpdate(sql);
           System.out.println(result);

       }
       catch (Exception e)
       {
           System.out.println(e);
       }
    }
}
