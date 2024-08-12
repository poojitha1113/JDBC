import java.sql.*;

public class Test_01 {
    public static void main(String[]args)  {
        //load
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            //2 conaction
            String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;integratedSecurity=false;encrypt=false;";
            String user="sa";
            String pass="jdbc";

            Connection connecion_obj = DriverManager.getConnection(url,user,pass);

            //3. prepare and extecute the quarry so crete the stament it help to extecute the quarry.
            //create the statment
            Statement statement_obj=connecion_obj.createStatement();

            //prepare quarry

            String create_Employee="create table Employee(EmolyeeId int,EmployeeName varchar)";
            //execute the statment

            int result=statement_obj.executeUpdate(create_Employee);
               System.out.println(result);

               //close the connection
            connecion_obj.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
