import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;

public class Librarian extends Registeration {
    public static void Welcome() throws IOException{
        try {
             
            File obj = new File("Readers.txt");
             
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
        Scanner scan = new Scanner(System.in);
        System.out.print("\u001b[2J");
        System.out.flush();
        System.out.println("\t\t              Welcome To LibraryManagementSystem :)           \n\n");
        System.out.println("you are a Librarian What do you'd like to do today :) ?");
        System.out.println("1-Add User\n2-Add Books\n3-Search for books\n4-Search for a member\n5-Block a user\n6-Rent a book\n6-Remove User\n7-Logout");
        System.out.println("Choice: ");
        int choice = scan.nextShort();

        switch(choice){
            case 1:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.adduser();
                break;
            }
            case 6:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.removeUser();
                break;
            }
            case 7:{ 
            System.out.print("\u001b[2J");
            System.out.flush();
            System.out.println("Logged Out!\n\n\n");
            Registeration R = new Registeration();
            R.login();
            break;
            }
            default:
            {
                System.out.println("Invalid Choice");
            }
        }
        //scan.close();
    }
    
    public static void adduser() throws FileNotFoundException
    {
        String name;
        String pass;
        String conpass;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter User's Name: ");
        name = s.nextLine();
        System.out.println("Enter User's Password: ");
        pass = s.nextLine();
        System.out.println("Confirm User's Password: ");
        conpass=s.nextLine();
        

        name=name.trim();
        pass=pass.trim();
        String x =name+" "+pass;

        if(pass.equals(conpass))
        {
             
              File f = new File("Readers.txt");
              Scanner file = new Scanner(f);
              int flag=0;
              while (file.hasNextLine()) {
                String data = file.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Already Registered");
                    flag=1;
                }
            }
              if(flag==0)
              {
                  try {
                      BufferedWriter out = new BufferedWriter(new FileWriter("Readers.txt", true)); 
                      out.write(name+" "+pass+"\n");
                      out.close();
                  }
                  catch (IOException e) {
                      System.out.println("exception occoured" + e);
                  }
                   
                  System.out.println("Successfully Registered");
                  
              }
              
                file.close();
        }
       // s.close();
    }
    public static void removeUser() throws IOException
    {
        Scanner s = new Scanner(System.in);

        File inventory = new File("Readers.txt");
        System.out.println("Enter User's Name: ");
        String name = s.nextLine();
        File temp = new File("deleteditems.txt");

        BufferedReader reader = new BufferedReader(new FileReader("Readers.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("deleteditems.txt"));
        temp.createNewFile();
        while((name = reader.readLine()) != null) {
          String trimmedLine = name.trim();
          if(!trimmedLine.contains(name)) {
             writer.write(name + 
                System.getProperty("line.separator"));
          }
        }
        reader.close(); 
        writer.close(); 
        inventory.delete();
        temp.renameTo(inventory);
        
    }
    public static void loginReader()
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
       
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();

        Uname=Uname.trim();
        Pass=Pass.trim();

        String x = Uname+" "+Pass;

        try {
              
            File f = new File("Readers.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
              String data = content.nextLine();
              if(data.equals(x))
              {
                  System.out.println("Welcome Reader!");
                  flag=1;
                  break;
              }
              
            }
              if(flag==0)
              {
                  System.out.println("Sorry :( You don't have an account ask the librarian for one...");
              }
              
             
            content.close();
          } 
          catch (FileNotFoundException e) {
           
               
            System.out.println("Error.");
            e.printStackTrace();
          }
       
    }
  
}
