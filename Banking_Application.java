import java.util.Scanner;

 class Banking_Application {
     public static void main(String[] args) {
         BankAccount obj1 = new BankAccount("XYZ", "SKC");
         obj1.showMenu();
     }
 }
    class BankAccount{
        int balance;
        int previoustransaction;
        String  customername;
        String customerid;

        BankAccount(String cname , String cid)  {  // Constructor for showMenu method , here we are taking two values
                customername = cname;               // Constructor have same name as of the class and do not have return type
                customerid = cid;                       // while creating the object of BankAccount we are going to pass two values in its constructor
            }                                               // why we are doing this :- we will need these values while displaying the welcome msg


        void deposit (int amount ){
            if (amount != 0 ){
                balance = balance+ amount ;
                previoustransaction = amount;
            }
        }

        void withdraw (int amount ){
            if (amount != 0){
                balance = balance - amount;
                previoustransaction = -amount;
            }
        }

        void getPrevioustransaction(){
            if (previoustransaction > balance ){
                System.out.println("Deposited : " +previoustransaction);
            }
            else if (previoustransaction < balance){
                System.out.println("Withdraw :-"+ Math.abs (previoustransaction)); // as we gave (-) sign to the amount just to classify that the amount has been withdraew
                                                                                                                 //Math.abs() make the amount positive.... can say it works as a MODULUS
             }
            else{
                System.out.println("No transaction has been occured");
            }
        }

        void showMenu(){

            Scanner sc = new Scanner (System.in);
            System.out.print("Enter the customer name : - " );
            String customername = sc.next();
            System.out.print( " Entert he customres id : - ");
            String customerid = sc.next();

            System.out.println(" Welcome " + customername);
            System.out.println(" Your ID is :- " + customerid);
            System.out.println("\n");
            System.out.println("What would you like to choose ");
            System.out.println(" A .  Check Balance");
            System.out.println(" B .  Deposit");
            System.out.println(" C .  Withdraw");
            System.out.println(" D .  Previous Transaction");
            System.out.println(" E .  Exit");
            char option = '\0';
            do{

                System.out.println("Enter the option : ");
                 option = sc.next().charAt(0);
                switch (option) {

                    case 'A' :
                        System.out.println("======================================================================================================");
                        System.out.println("Balance is " +balance);
                        System.out.println("======================================================================================================");

                        break;
                    case 'B' :
                        System.out.println("======================================================================================================");
                        System.out.println("Enter the amount to deposit :- ");
                        int amount= sc.nextInt();
                        deposit(amount);
                        System.out.println("======================================================================================================");

                        break;

                    case 'C' :
                        System.out.println("======================================================================================================");
                        System.out.println("Enter the amount to withdraw :- ");
                        int amount2= sc.nextInt();
                        withdraw(amount2);
                        System.out.println("======================================================================================================");

                        break;
                    case 'D' :
                        System.out.println("======================================================================================================");
                        getPrevioustransaction();
                        System.out.println("======================================================================================================");

                        break;
                    default :
                        System.out.println("======================================================================================================");
                        System.out.println("Invalid option ! ! Please enter again");
                        System.out.println("======================================================================================================");

                        break;
                }
            }
            while (option !='E');
            System.out.println("Thank You for using our service");

        }
    }

