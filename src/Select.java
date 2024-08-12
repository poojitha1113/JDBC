import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Select {
    public static void main(String[]args)
    {
        //1.load and register driver
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //2.establish the connection
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=HCM;integratedSecurity=false;encrypt=false;";

            String user="sa";
            String pass="jdbc";
            Connection connectionobj=DriverManager.getConnection(url,user,pass);

            //create statment
            String sql="select * from EmployeerLogin";
            //execute quary need a platform so have to create stament
            Statement statementobj=connectionobj.createStatement();
            ResultSet rs=statementobj.executeQuery(sql);
            System.out.println(rs.getStatement());
            LinkedList<Object> list=new LinkedList<Object>();

            System.out.println(list.get(rs.getInt(0)));
            connectionobj.close();

        }
        catch (Exception e)
        {

        }
    }

}
