import java.util.*;
interface AtmMachine

{
void withdraw(int amount);
void deposit(int amount);
void checkBalance();
}
class User
{
    String name;
    int balance=0;
    int account_number;
    User(String n,int acc)
    {
        name=n;
        account_number=acc;
    }

}
class Atm implements AtmMachine
{
    User user;
    Atm(User obj)
    {
     user=obj;
    }
 public void withdraw(int amount)
 {
   if(amount>user.balance)
   {
    System.out.println("Insufficient Balance");
    return;
   }
   user.balance-=amount;
   System.out.println("Withdraw Sucessfully");
   System.out.println("Please Take Your Card and Cash");
 }
 public void deposit(int amount)
 {
  user.balance+=amount;
  System.out.println("Amount Sucessfully Creadited to Your Account ");
 }
 public void checkBalance()
 {
    System.out.println("Your Current Balance is :"+user.balance);
 }

}
class Atm_Machine
{
public static void main(String[] args)
{
    Scanner obj=new Scanner(System.in);
    ArrayList<User> al=new ArrayList<User>();
    int acc;
    int amt;
    Atm atm;
    while(true)
    {
        System.out.println(" 1.CREATE A ACCOUNT \n 2.DEPOSIT \n 3.WITHDRAW \n 4.CHECK BALANCE \n 5.EXIT");
        System.out.println(" Enter Your Choice: ");
        int ch=obj.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("Enter Name:");
                obj.nextLine();
                String name=obj.nextLine();
                System.out.println("Account Created Successfully ");
                al.add(new User(name,al.size()+1));
                System.out.println("Your Account Number is :"+al.size());
                break;
            case 2:
                System.out.println("Enter Account Number: ");
                acc=obj.nextInt();
                if(acc>al.size())
                {
                    System.out.println("Invalid Account Number");
                    return;
                }
                System.out.println("Enter Amount to Deposit :");
                amt=obj.nextInt();
                atm=new Atm(al.get(acc-1));
                atm.deposit(amt);
                break;
            case 3:
                System.out.println("Enter Account Number: ");
                acc=obj.nextInt();
                if(acc>al.size())
                {
                    System.out.println("Invalid Account Number");
                    return;
                }
                System.out.println("Enter Amount to Withdraw :");
                amt=obj.nextInt();
                atm=new Atm(al.get(acc-1));
                atm.withdraw(amt);
                break;
           
            case 4:
                System.out.println("Enter Account Number: ");
                acc=obj.nextInt();
                if(acc>al.size())
                {
                    System.out.println("Invalid Account Number");
                    return;
                }
                new Atm(al.get(acc-1)).checkBalance();
                break;

            case 5:
                return;

        }
        
        
    }
}
}