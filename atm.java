package atm.java;
import java.util.ArrayList;

import java.util.Scanner;

class atm{
    int Id;
    int Pin;


    public static Scanner sc = new Scanner(System.in);
        public static ArrayList<String>list = new ArrayList<>();


      //transaction
        public static void transac(int balance){
        for(String i:list){
            System.out.println(i);
        }
        ask(balance);
      }

      public static void login(int userId, int pin){
        if(userId == 101 && pin == 1212){
            list.add("Logged In");
            System.out.println("------------Logged In------------");
            System.out.println("------------Welcome to the ATM------------");
            ask(1000);
        }
        else{
            System.out.println("Enter valid userId or pin");
            login(sc.nextInt(), sc.nextInt());
        }
    
       }
  
    
  //withdrawn
    public static void withdrawn(int balance, int amount) {
    if(amount<=balance && amount >=0){
        balance= balance - amount;
        System.out.println("Transaction Successful, Current balance is " +balance);
        list.add("Rupee/'s " + amount + " withdrawn.");
        ask(balance);
    }
    else{
        System.out.println("Transcation Failed.");
        ask(balance);
       // withdrawn(balance, sc.nextInt()); //at same time agian enter the amount
    }
  }

  //deposite
  public static void deposite(int balance, int amount) {
    if(amount >= 0) {
        balance = balance + amount;
        System.out.println("Transaction Successful, Current balance is " + balance);
        list.add(amount +" Rupee/'s deposited.");
        ask(balance);
    }
    else{
        System.out.println("Enter valid amount to deposite.");
    }
    
  }

  //transfer
   public static void transfer(int balance, int amount) {
    if(amount<= balance && amount >= 0) {
        System.out.println("Enter userId of reciver: ");
        Integer user = sc.nextInt();

        balance= balance - amount;
        System.out.println(amount +" Rupee/'s sent to "+ user);
        System.out.println("Transcation Successful, Current balance is: "+ balance);

        list.add(amount+" Transfered to account "+ user);
        ask(balance);
    }
    else{
        System.out.println("Enter a valid userId");
        transfer(balance, sc.nextInt());
    }
    
  }

  //quit
  public static void quit(int balance){
    
    if( sc.next().charAt(0)  == 'Y' || sc.next().charAt(0) == 'y') {
        System.out.println("------------Logged Out------------");
        System.out.println();
    }
    else{
      ask(balance);
    }
   }


    public static void ask(int bal) {
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposite");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.println("Select any one of the actions:-");
    
        int opt = sc.nextInt();
        System.out.println();
        if(opt < 1 || opt > 5){
            System.out.println("Select valid action.");
            ask(bal);
        }
        else{
            switch (opt){
                case 1:
                System.out.println("------------Transcation History------------");
                transac(bal);
                break;
    
                case 2:
                System.out.println("Enter amount to be withdrawn: ");
                withdrawn(bal, sc.nextInt());
                break;
    
                case 3:
                System.out.println("Enter amount to be deposited: ");
                deposite(bal, sc.nextInt());
                break;
    
                case 4:
                System.out.println("Enter amount to be transfered: ");
                transfer(bal, sc.nextInt());
                break;
    
                case 5:
                System.out.println("Do you want to exit/quit? (YES/NO): ");
                
                quit(bal);
                break;
            }
        }
    }



     public static void main(String[] args) {
        System.out.println("UserId = 101 and Pin = 1212");
        System.out.println();
        System.out.println("------------Login------------");
        System.out.println("Enter userId: ");
        int userId = sc.nextInt();
        System.out.println("Enter pin: ");
        int pin = sc.nextInt();

        login(userId, pin);
            
     }
}



