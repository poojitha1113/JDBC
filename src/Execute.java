import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

public class Execute {
    public static void main(String[]args)
    {
        try {
        //1. load and register driver
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //2. connection
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";

            Connection connectionobj=DriverManager.getConnection(url,user,pass);

            //3.crete and execute the quarry
            String slectquarry="select * from leave";
            String insertQuarry="insert into leave values(105,1,LOP)";
            //execute and create statement
            Statement statementobj=connectionobj.createStatement();
            boolean result=statementobj.execute(slectquarry);
            if (result==true)
            {
                ResultSet rs= statementobj.getResultSet();
                while (rs.next()){
                System.out.println(rs.getInt(1)+""+rs.getInt(2)+""+rs.getString(3));
            }}
            else {

                        System.out.println(result);
            }
            }
            catch (Exception e)
        {

        }
    }
}
