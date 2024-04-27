
package banking_sys;


public class MainClass {

    public static void main(String[] args){
//        User u=new User();
//        AuthenticationService a=new AuthenticationService();
//        a.login();
           BankAccount bk=new BankAccount();
           bk.storeAccountDetails("arati", "48834593", 1900, true, 1);
    }
}
