import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
 
public class Registeration {
     
    private void register() throws FileNotFoundException
    {
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        
         
        System.out.println("Confirm Password: ");
        String ConPass=sc.nextLine();
        System.out.println(ConPass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        ConPass=ConPass.trim();
         
         
         
 
        String x= Uname+" "+Pass;
        if(Pass.equals(ConPass))
        {
             
              File f = new File("Registration.txt");
              Scanner content = new Scanner(f);
               
               
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Already Registered");
                    flag=1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        this.register();
                    }
                    else if(choice==2)
                    {
                        this.login();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
                content.close();
              }
                if(flag==0)
                {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true)); 
                        out.write(Uname+" "+Pass+"\n");
                        out.close();
                    }
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("Successfully Registered");
                    System.out.println("Please login");
                    this.login();
                }
             
             
        }
        else
        {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");
             
            System.out.println("Enter your Choice");
            int choice=sc.nextInt();
            if(choice==1)
            {
                this.register();
            }
            else if(choice==2)
            {
                this.login();
            }
            else
            {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }
     
    public void login()
    {
         
        Scanner sc=new Scanner(System.in);
         
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("Registration.txt");
              Scanner content = new Scanner(f);
              int flag=0;
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Login Successful");
                    System.out.println("Welcome to the Application.");
                    flag=1;
                    break;
                }
              }
                if(flag==0)
                {
                    System.out.println("Login Failed");
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");
                     
                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        this.register();
                    }
                    else if(choice==2)
                    {
                        this.login();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                }
               
              content.close();
            } 
            catch (FileNotFoundException e) {
             
                 
              System.out.println("Error.");
              e.printStackTrace();
            }
         
        sc.close();
    }
     
    public static void main(String[] args) throws FileNotFoundException{
     
        try {
             
              File obj = new File("Registration.txt");
               
              if (obj.createNewFile()) 
              {
                System.out.println("File is created");
              } 
               
            } 
            catch (IOException e) 
            {
              System.out.println("An error occurred.");
              e.printStackTrace();
               
            }
         
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Registration. ");
        System.out.println("2. Login. ");
         
        System.out.println("Enter your Choice");
        choice=sc.nextInt();
        sc.nextLine();
         
        if(choice==1)
        {
            Registeration user = new Registeration();
            user.register();
        }
        else if(choice==2)
        {
            Registeration user = new Registeration();
            user.login();
        }
        else
        {
            System.out.println("Choose Proper Option");
        }
        sc.close();
    }
     
}