package banking_sys;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class BankAccount {
    private String username;
    private String accountNumber;
    private double balance;
    private boolean isActive;
    private double interestRate;
    private static final String db_url="jdbc:mysql://localhost:3306/banking_system";
    private static final String db_user="root";
    private static final String db_pass="KomusMySql@1461";
    private Connection connection;

    public void storeAccountDetails(String username,String accountNumber,double balance, boolean isActive, double interestRate){
        String query="insert into account_details(username,account_number, balance, is_active,interest_rate) values(?,?,?,?)";
        try {
            connection=DriverManager.getConnection(db_url,db_user,db_pass);
            PreparedStatement statement =connection.prepareStatement(query);
            System.out.println("hello");
        
        }
        catch (SQLException e) {
            System.out.println("sorry");
        }
    
    }    
}
