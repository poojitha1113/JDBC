import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class InsertDataInto_Employee {
    public static Connection connectionobj;
    public static  PreparedStatement statementobj;


    public static String url = "jdbc:sqlserver://localhost\\MSSQL2022:1433;databaseName=Testdb;integratedSecurity=false;encrypt=false;";

    public static String user = "sa";
    public static String pass = "jdbc";

    public static void loadandRegisterDrvier() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Establish_the_Connection() throws SQLException {
        connectionobj = DriverManager.getConnection(url, user, pass);
    }

    public static void createandexecutequarry() throws SQLException {
        int EmployeeId;
        String EmployeeFirstname;
        String EmployeeLastname;
        String EmployeeAddress;

        Float Esalary;

        Scanner sc = new Scanner(System.in);

            while (true) {
                    System.out.println("Enter the EmpId");
                    EmployeeId = sc.nextInt();

                    System.out.println("Enter the EmployeeFirstname");
                    EmployeeFirstname = sc.next();

                    System.out.println("Enter the EmployeeLastname");
                    EmployeeLastname = sc.next();

                    System.out.println("Enter Employee Address");
                    EmployeeAddress = sc.next();

                    System.out.println("Enter Employee Salary");
                    Esalary = sc.nextFloat();

                    //String sqlinserton="SET IDENTITY_INSERT EmployeeData ON; ";
                    String sqlinsertQuarry = "insert into EmployeeData values(?,?,?,?,?);";
                    // String sqlinsertoff="SET IDENTITY_INSERT EmployeeData OFF;";

                   //stament we are using prepared stament for dynamic quaarys


                    statementobj = connectionobj.prepareStatement(sqlinsertQuarry);

                    statementobj.setInt(1, EmployeeId);
                    statementobj.setString(2, EmployeeFirstname);
                    statementobj.setString(3, EmployeeLastname);
                    statementobj.setString(4, EmployeeAddress);
                    statementobj.setFloat(5, Esalary);


                    int i = statementobj.executeUpdate();
                    System.out.println(i);
                    System.out.println("do you want to enter the multiple recoreds Yes/NO");

                    String option= sc.next();
                    sc.next();
                    if(option.equalsIgnoreCase("No"))
                    {
                        break;
                    }
                }
    }
    public static void selectquarry() throws SQLException {
        String sql="select * from EmployeeData";
        statementobj=connectionobj.prepareStatement(sql);
        ResultSet rs=statementobj.executeQuery();

        System.out.println(rs.getStatement());
        while (rs.next())
        {

                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getFloat(5));

        }
        System.out.println("");

    }
        public static void close () throws Exception
        {
            connectionobj.close();
        }

        public static void main (String[]args) throws Exception
        {
            loadandRegisterDrvier();
            Establish_the_Connection();
            selectquarry();
           // createandexecutequarry();

            close();

        }
    }

