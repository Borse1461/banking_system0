
package banking_sys;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AuthenticationService {
    String db_url="jdbc:mysql://localhost:3306/banking_system";
    String db_user="root";
    String db_pass="KomusMySql@1461";
    private Connection connection;
    String pass;
    public AuthenticationService(){
        try {
            connection=DriverManager.getConnection(db_url,db_user,db_pass);
        } catch (SQLException e) {
        }
    }
            
    public String login(){
        String username;
        String password;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Login to Your account");
            System.out.println("Enter User Name");
            username = sc.nextLine();
            System.out.println("Enter Password");
            password = sc.nextLine();
        }
        
        try {
            this.pass=password;
            PreparedStatement statement=connection.prepareStatement("select * from users where username = ?");
            statement.setString(1, username);
            ResultSet resultSet=statement.executeQuery();
           
            if(resultSet.next()){
                String hashePasswords=resultSet.getString("password");
               if(password.equals(hashePasswords)){
                   System.out.println("You login successfully");
               }
               else
               {
                   System.out.println("login fail");
                   System.out.println("Please enter correct password");
               }
            }
            else{
                System.out.println("Login fails");
            }
        } catch (SQLException e) {
        }
        return null;
    }

//    public Object hashPassword(String password) {
//        try {
//            MessageDigest digest=MessageDigest.getInstance("SHA-256");
//            byte[] hash=digest.digest(password.getBytes());
//            StringBuilder hexString =new StringBuilder();
//            for(byte b:hash){
//                String hex=Integer.toHexString(0xff & b);
//                if(hex.length()==1)hexString.append('0');
//                hexString.append(hex);
//                System.out.println("success");
//            }
//            return hexString.toString();
//            
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
