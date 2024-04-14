import java.util.*;
class NumberGuess
{
    public static void main(String[] args)
    {
    Random rand=new Random();
    Scanner obj=new Scanner(System.in);
    int ch=1;
    int score=0;
    System.out.println("****************************NUMBER GUESSING GAME**************************");
    System.out.println("RULES: \n 1)Guess The Number Between 1 to 100 \n 2)You Have only 3 Chances to Guess The Single Number \n 3)Hint Will Be Provided if Guessing Number is Incorrect");
    System.out.println("Welcome to Number Guessing Game!!!");
    System.out.println("Enter Your Name to Play Game : ");
    String name=obj.nextLine();
    while (ch!=0)
    {
    int guess=rand.nextInt(101)+1;
    int chances=3;
    while(chances>0)
    {   
        System.out.println("Try to Guess The Number Between 1 to 100 : ");
        int num=obj.nextInt();
        if(num==guess)
        {
            System.out.println(" Well Done!!!.You Guessed the Number Guessed Number is :"+num);
            score++;
            break;
        }
        else if(num>guess)
        {
            System.out.println(" Good try,But Unlucky Wrong. Guessed Number is Less than "+num+"\n You Have "+(chances-1)+" Only Please Try Again");
        }
        else 
        {
            System.out.println(" Good try,But Unlucky Wrong. Guessed Number is Greater than "+num+"\n You Have "+(chances-1)+" Only Please Try Again");
        }
        chances--;

    }
    System.out.println(" Guessed Number is :"+guess);
    System.out.println(" Enter 0 to Quit The game \n Enter Other Number to Play :");
    ch=obj.nextInt();
    }
    System.out.println(" Well Done! "+name+"  \n Your Score is :"+score+"\n Thank You For Playing");

    }
}