import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import javax.xml.transform.stream.StreamSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Tc_001 {
    public static void main(String[] args) {
        //1. load and register the driver
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //2.establish connection between the java and db
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";
            Connection connectionobj=DriverManager.getConnection(url,user,pass);
            //3.crete and execute statment
            String sql="insert ino EmployeeData values(105,'poojitha','gutha','iowa',30.5)";
            PreparedStatement statementobj=connectionobj.prepareStatement(sql);
            int result=statementobj.executeUpdate();
            System.out.println(result+"done");

        }
        catch (Exception e)
        {
            System.out.println(e+"notdone");
        }

    }
}
