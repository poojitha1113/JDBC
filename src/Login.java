import  java.sql.*;
public class Login {

    public static void main(String[]args)  {
        System.out.println("Enter the login details");
        //1) need pakages
        //2) load and register the dirvere
try {
    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

    //3) establish the connection
    String url="jdbc:sqlserver://localhost\\MSSQL2022:1433;integratedSecurity=false;encrypt=false;";
    String user="sa";
    String pass="jdbc";

    Connection connectionobj=DriverManager.getConnection(url,user,pass);

    //4)System objects and create and execute the quarry
    String sql="insert into employee (EId) values (105)";

    Statement statementobj=connectionobj.prepareStatement(sql);
    statementobj.executeUpdate(sql);
    connectionobj.close();
    System.out.println("close");


}
catch (Exception e)
    {
        System.out.println(e);

}
    }
}
