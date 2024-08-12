import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collections;

public class Create_table {
    public static void main(String []args)
    {
        System.out.println("creating the table");
        //1.get the connection
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //2.establish the connection
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";
            Connection connectionobj=DriverManager.getConnection(url,user,pass);

            //create and extecute the quarry
            String sql="create table Leave(EmployeeId integer,Leave_type varchar,No_of_leaves integer)";

            //crete the platform to extecute it

            Statement platform=connectionobj.createStatement();
            int result=platform.executeUpdate(sql);
            System.out.println(result);

            //close the connection

            connectionobj.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
