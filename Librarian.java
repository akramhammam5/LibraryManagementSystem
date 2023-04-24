import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

public class Libraria extends Registeration {
    public static void Welcome() throws FileNotFoundException{
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
        System.out.println("1- Add User\n2- Add Books\n3-Search for books\n4-Search for a member\n5-Block a user\n6-Rent a book\n6-Logout\n");
        System.out.println("Choice: ");
        int choice = scan.nextShort();

        switch(choice){
            case 1:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Libraria.adduser();
                break;
            }
            case 6:{ 
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
        int id;
        String conpass;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter User's Name: ");
        name = s.nextLine();
        System.out.println("Enter User's Password: ");
        pass = s.nextLine();
        System.out.println("Confirm User's Password: ");
        conpass=s.nextLine();
        System.out.println("Enter User's ID: ");
        id = s.nextInt();

        name=name.trim();
        pass=pass.trim();
        String x=name+" "+pass+" "+id;

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
                      out.write(name+" "+pass+" "+id+"\n");
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
    
}
