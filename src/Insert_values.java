import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collections;

public class Insert_values {
    public static void main(String[]args)
    {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //2.establish the connection
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";
            Connection connection_obj=DriverManager.getConnection(url,user,pass);
            //create the quarry
            String sql="insert into leave values(103,3,'paid leave')";

            //execute quarry
            //crete a plaform to execute the quaary with the help of stament

            Statement statementobj=connection_obj.createStatement();
            int result=statementobj.executeUpdate(sql);
            System.out.println(result);

            connection_obj.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
