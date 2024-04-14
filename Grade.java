import java.util.*;
class Student {
  String name;
  float mark1,mark2,mark3,mark4,mark5,total,average;
  char grade;
  Student(String n, float m1, float m2, float m3, float m4, float m5) {
    name = n;
    mark1=m1;
    mark2=m2;
    mark3=m3;
    mark4=m4;
    mark5=m5;
    total = m1 + m2 + m3 + m4 + m5;
    average = total / 5;
    if (average >= 90) {
      grade = 'A';
    } else if (average >= 80) {
      grade = 'B';
    }
  
  else if (average >= 70) {
    grade = 'C';
  }
 else if (average >= 60) {
  grade = 'D';
} else if (average >= 35) {
  grade = 'E';
} else {
  grade = 'U';
}
}

}
class Grade {
  static Student stu_obj[];
  static int n;
  static int count = 0;
  static Scanner obj = new Scanner(System.in);
  static void insert_each() {
    for (int i = 0; i < n; i++) {
      System.out.println(" For Roll Number " + (i + 1));
      System.out.println(" Do You Want to Skip This Roll Number(After You Can Update)?? Enter 1 For Skip \n  Otherwise Enter Some Number....");
      int ch = obj.nextInt();
      obj.nextLine();
      if (ch == 1) {
        continue;
      }
      System.out.println("Enter Student Name :");
      String name = obj.nextLine();
      System.out.println("Enter Five Subject Mark Of Student " + name + ":");
      System.out.println("Enter Subject 1 Mark: ");
      float m1 = obj.nextInt();
      while(m1<0 ||m1>100)
      {
        System.out.println(" Mark1 Must Be Between 0 and 100 only please try again");
        m1=obj.nextFloat();
      }
      System.out.println("Enter Subject 2 Mark: ");
      float m2 = obj.nextFloat();
      while(m2<0 ||m2>100)
      {
        System.out.println(" Mark2 Must Be Between 0 and 100 only please try again");
        m2=obj.nextFloat();
      }
      System.out.println("Enter Subject 3 Mark: ");
      float m3 = obj.nextFloat();
      while(m3<0 ||m3>100)
      {
        System.out.println(" Mark3 Must Be Between 0 and 100 only please try again");
        m3=obj.nextFloat();
      }
      System.out.println("Enter Subject 4 Mark: ");
      float m4 = obj.nextFloat();
      while(m4<0 ||m4>100)
      {
        System.out.println(" Mark4 Must Be Between 0 and 100 only please try again");
        m4=obj.nextFloat();
      }
      System.out.println("Enter Subject 5 Mark: ");
      float m5 = obj.nextFloat();
      while(m5<0 ||m5>100)
      {
        System.out.println(" Mark5 Must Be Between 0 and 100 only please try again");
        m5=obj.nextFloat();
      }
      stu_obj[i] = new Student(name, m1, m2, m3, m4, m5);
      count++;
    }
    System.out.println(" You Enter " + count + " Records .Skipped Record is : " + (n - count));

  }
  static void update(int roll)
  {
    if(roll>n)
    {
      System.out.println("Invaild Roll Number");
      return;
    }
    System.out.println("Enter Name For Roll Number "+roll+" : ");
    obj.nextLine();
    String name=obj.nextLine();
    System.out.println("Enter Mark 1 : ");
    float m1=obj.nextFloat();
    System.out.println("Enter Mark 2 : ");
    float m2=obj.nextFloat();
    System.out.println("Enter Mark 3 : ");
    float m3=obj.nextFloat();
    System.out.println("Enter Mark 4 : ");
    float m4=obj.nextFloat();
    System.out.println("Enter Mark 5 : ");
    float m5=obj.nextFloat();
    stu_obj[roll-1]=new Student(name,m1,m2,m3,m4,m5);
   
  }
  static void display_all()
  {
    for(int i=0;i<stu_obj.length;i++)
    {
        if(stu_obj[i]!=null)
        {
        System.out.println("*******************************************************************************");
        System.out.println("Roll Number :"+(i+1));
        System.out.println("Name :"+stu_obj[i].name);
        System.out.println("Mark 1 :"+stu_obj[i].mark1);
        System.out.println("Mark 2 :"+stu_obj[i].mark2);
        System.out.println("Mark 3 :"+stu_obj[i].mark3);
        System.out.println("Mark 4 :"+stu_obj[i].mark4);
        System.out.println("Mark 5 :"+stu_obj[i].mark5);
        System.out.println("Total :"+stu_obj[i].total);
        System.out.println("Average :"+stu_obj[i].average);
        System.out.println("Grade :"+stu_obj[i].grade);
        System.out.println("*******************************************************************************");
        }
    }
  }
  static void display_one(int roll)
  {
    if(stu_obj[roll-1]==null)
       {
        System.out.println("Record Not Found For This Roll Number");
        return;
       }
    System.out.println("Roll Number:"+roll);
    System.out.println("Name :"+stu_obj[roll-1].name);
    System.out.println("Mark 1 :"+stu_obj[roll-1].mark1);
    System.out.println("Mark 2 :"+stu_obj[roll-1].mark2);
    System.out.println("Mark 3 :"+stu_obj[roll-1].mark3);
    System.out.println("Mark 4 :"+stu_obj[roll-1].mark4);
    System.out.println("Mark 5 :"+stu_obj[roll-1].mark5);
    System.out.println("Total :"+stu_obj[roll-1].total);
    System.out.println("Average :"+stu_obj[roll-1].average);
    System.out.println("Grade :"+stu_obj[roll-1].grade);
  }
  static void delete(int roll)
  {
    if(roll>n||stu_obj[roll-1]==null)
       {
        System.out.println("Invalid Roll Number");
       }
    else
       {
        stu_obj[roll-1]=null;
       }
  }
  public static void main(String[] args) {
    System.out.println("***************************STUDENT GRADE CALCULATOR*****************");
    System.out.println("Enter Number Of Student in Class: ");
    n = obj.nextInt();
    stu_obj=new Student[n];
    while (true) {
      System.out.println(" 1.Enter Mark Details for Each Student \n 2.Enter Mark Detail(or Update) For Spefic Student \n 3.Display All Student Records \n 4.Display Student Record For Spefic Student. \n 5.Remove Student \n 6.EXIT");
      System.out.println(" Enter Your Choices :");
      int choice=obj.nextInt();
      
      switch(choice)
      {
        case 1:insert_each();break;
        case 2:
            System.out.println(" Enter Roll Number To Update :");
            int rollforupdate=obj.nextInt();
            update(rollforupdate);
            break;
        case 3:display_all();break;
        case 4:
               System.out.println(" Enter Roll Number To Display :");
               int rollfordisplay=obj.nextInt();
               display_one(rollfordisplay);
               break;
        case 5:
              System.out.println(" Enter Roll Number To Delete :");
              int rollfordelete=obj.nextInt();
              delete(rollfordelete);
              break;
        case 6:
             System.out.println("Exiting..... Thank You!");
             return;
      }

    }
  }
}