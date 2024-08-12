import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update_data {
    public static void main(String[]args)
    {
        //1.load and register the driver
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        //establish the connection
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";
            Connection connection_obj=DriverManager.getConnection(url,user,pass);

            //create the quarry
            String sql="update leave set No_of_leaves=5 where EmployeeId=101";
            //extecute the statment
            //create the platform
            Statement statement_obj=connection_obj.createStatement();
            int result=statement_obj.executeUpdate(sql);
            //close the connection
            System.out.println(result);
            connection_obj.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
