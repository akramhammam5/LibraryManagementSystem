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

public class Librarian extends Book {
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
        System.out.println("1-Add User\n2-Add Books\n3-Search for books\n4-Search for a member\n5-Block a user\n6-Rent a book\n6-Remove User\n7-Remove Book\n8-Logout");
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
            case 2:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.AddBook();
                break;
            }
            case 3:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.SearchBook();
                break;
            }
            case 4:
            {
              System.out.print("\u001b[2J");
              System.out.flush();
              Librarian.searchUser();
              break;
            }
            case 6:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.removeUser();
                break;
            }
            case 7:
            {
                System.out.print("\u001b[2J");
                System.out.flush();
                Librarian.removeBook();
                break;
            }

            case 8:{ 
            System.out.print("\u001b[2J");
            System.out.flush();
            System.out.println("Logged Out!\n\n\n");
            Main R = new Main();
            R.main(null);
            break;
            }
            default:
            {
                System.out.println("Invalid Choice");
            }
        }
        //scan.close();
    }
    
    public static void adduser() throws IOException
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
        String x ="Name: "+name+" "+"Password: "+pass;

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
                      out.write("Name: "+name+" "+"Password: "+pass+"\n");
                      out.close();
                  }
                  catch (IOException e) {
                      System.out.println("exception occoured" + e);
                  }
                   
                  System.out.println("Successfully Registered");
                  
              }
              
                file.close();
                Librarian.Welcome();
        }
       // s.close();
    }
    public static void removeUser() throws IOException
    {
        Scanner s = new Scanner(System.in);


        File fileToBeModified = new File("Readers.txt");
        System.out.println("Enter User's Name: ");
        String name = s.nextLine();
        // construct temporary file
        File inputFile = new File("Readers.txt");
        File tempFile = new File(inputFile + "temp.txt");

        BufferedReader br = new BufferedReader (new FileReader("Readers.txt"));
        PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
        String line = null;

     //read from original, write to temporary and trim space, while title not found
     while((line = br.readLine()) !=null) {
         if(line.trim().startsWith(name)){
             continue;          }
         else{
             Pwr.println(line);
             Pwr.flush();

         }
     }
     // close readers and writers
     br.close();
     Pwr.close();

     // delete book file before renaming temp
     inputFile.delete();

     // rename temp file back to books.txt
     if(tempFile.renameTo(inputFile)){
            System.out.println("Update succesful");
        }else{
            System.out.println("Update failed");
        }
        Librarian.Welcome();
       
        
    }
    public static void searchUser() throws IOException
    {
      Scanner s = new Scanner(System.in);
      Scanner input = new Scanner(new File("Readers.txt"));
      System.out.println("Enter the name of the user you want to search about: ");
      String u = s.nextLine();
      while (input.hasNext()) {
        String search = input.nextLine().toLowerCase().toString();
        if (search.contains(u)) { 
            System.out.println(search);
        }
    }
      


    }
    public static void BlockUser() throws IOException
    {
      
    }
    public static void AddBook() throws IOException
    {
        
        long i;
        float p;
        Book b = new Book();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Book's Name: ");
        b.Title = s.nextLine();
        System.out.println("Enter Author's Name: ");
        b.Author = s.nextLine();
        System.out.println("Enter Number of books to add: ");
        b.Num_of_copies = s.nextInt();
        System.out.println("Enter Book Price: ");
        p = s.nextFloat();
        b.setPrice(p);
        System.out.println("Enter Book's Genre: ");
        b.Genre = s.nextLine() + s.nextLine();
        System.out.println("Enter Book's Location: ");
        b.Location = s.next();
        System.out.println("Enter Book's ISBN: ");
        i = s.nextLong();
        b.setIsbn(i);

        b.Title=b.Title.trim();
        b.Author=b.Author.trim();
        b.Genre=b.Genre.trim();
        b.Location=b.Location.trim();
        

        String x = "Title: "+b.Title+" "+"Author: "+b.Author+" "+"Genre: "+b.Genre+" "+"Location: "+b.Location+" "+"Copies: "+b.Num_of_copies+" "+"ISBN: "+b.getIsbn()+" "+"Price: "+b.getPrice();

        File f = new File("Books.txt");
        try{
        if (f.createNewFile()) 
            {
              System.out.println("File is created");
            } 
             
          } 
          catch (IOException e) 
          {
            System.out.println("An error occurred.");
            e.printStackTrace();
             
          }
            Scanner file = new Scanner(f);
              int flag=0;
              while (file.hasNextLine()) {
                String data = file.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Already Added");
                    flag=1;
                }
    }
            if(flag==0)
              {
                  try {
                      BufferedWriter out = new BufferedWriter(new FileWriter("Books.txt", true)); 
                      out.write(b.Title+" "+"Author: "+b.Author+" "+"Gnere: "+b.Genre+" "+"Location: "+b.Location+" "+"Copies: "+b.Num_of_copies+" "+"ISBN: "+b.getIsbn()+" "+"Price: "+b.getPrice()+"$"+"\n");
                      out.close();
                  }
                  catch (IOException e) {
                      System.out.println("exception occoured" + e);
                  }
                   
                  System.out.println("Successfully Registered");
                  
              }
              
                file.close();
                Librarian.Welcome();
        }
public static void removeBook() throws IOException
    {
        Scanner s = new Scanner(System.in);

        File fileToBeModified = new File("Books.txt");
        System.out.println("Enter Book's Name: ");
        String name = s.nextLine();
        // construct temporary file
        File inputFile = new File("Books.txt");
        File tempFile = new File(inputFile + "temp.txt");

        BufferedReader br = new BufferedReader (new FileReader("Books.txt"));
        PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
        String line = null;

     //read from original, write to temporary and trim space, while title not found
     while((line = br.readLine()) !=null) {
         if(line.trim().startsWith(name)){
             continue;          }
         else{
             Pwr.println(line);
             Pwr.flush();

         }
     }
     // close readers and writers
     br.close();
     Pwr.close();

     // delete book file before renaming temp
     inputFile.delete();

     // rename temp file back to books.txt
     if(tempFile.renameTo(inputFile)){
            System.out.println("Update succesful");
        }else{
            System.out.println("Update failed");
        }
        Librarian.Welcome();
    }
    public static void SearchBook() throws FileNotFoundException
    {
      Scanner s = new Scanner(System.in);
      Scanner input = new Scanner(new File("Books.txt"));
      System.out.println("Enter the name of the Book you want to search about: ");
      String u = s.nextLine();
      while (input.hasNext()) {
        String search = input.nextLine().toString();
        if (search.contains(u)) { 
            System.out.println(search);
        }
    }
 }
}

  

