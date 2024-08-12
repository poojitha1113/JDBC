import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee  {
    public static void main(String[]args) {

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            Connection connectionobj = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;user=sa;password=jdbc");
            //getconnection it gives the instance of connection
            //connection it is interface and it implents a class Drivermanager so that ther is a methos id getconnection
            String sql = "create table employee(EId Integer )";

            Statement statementobj = connectionobj.createStatement();
            statementobj.executeUpdate(sql);
            connectionobj.close();

            System.out.println("Done");
        } catch (Exception e) {
                System.out.println(e);
        }
    }
    }

