import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Request extends Book{
   
    private static int ID = 1;
    String Request_Date;
    String Due_Date;


    public static void Buy() throws IOException
    {
        Scanner s = new Scanner(System.in);
        Book b = new Book();
        
        System.out.println("Enter the name 0f the Book: ");
        String name = s.nextLine();
        System.out.println("Enter the Purchase Date: ");
        String date = s.nextLine();
        System.out.println("Enter the number of copies: ");
        int copies = s.nextInt();
        System.out.println("Enter the price of the book: ");
        float p = s.nextFloat();
        b.setPrice(p);
        float Total = b.getPrice()*copies;
        Formatter x = null;
        File f = new File("Bought.txt");
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
    try {
        FileWriter r = new FileWriter("Bought.txt", true);
        x = new Formatter(r);
        x.format("%d %s %s %s%n",ID++,name);
        x.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
    String str =ID+" "+"Name: "+name+" "+"Purchase date: "+date+" "+"Copies Number: "+copies+" "+"Total price: "+Total;
     
              File r = new File("Bought.txt");
              Scanner file = new Scanner(f);
              int flag=0;
              while (file.hasNextLine()) {
                String data = file.nextLine();}
                File fileToBeModified = new File("Books.txt");
                // construct temporary file
                File inputFile = new File("Books.txt");
                File tempFile = new File(inputFile + "temp.txt");

                BufferedReader br = new BufferedReader (new FileReader("Books.txt"));
                PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
                String line = null;

            //read from original, write to temporary and trim space, while title not found
            while((line = br.readLine()) !=null) {
                if(line.trim().startsWith(name)){
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("Bought.txt", true)); 
                        out.write(ID+" "+"Name: "+name+" "+"Purchase date: "+date+" "+"Copies Number: "+copies+" "+"Total price: "+Total+"\n");
                        out.close();
                        
                      }
                    
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("Payment Succeeded :)");
                    Reader.loginReader();
                }
                else{
                    File fileToBeModify = new File("Bought.txt");
                    // construct temporary file
                    File inputFil = new File("Bought.txt");
                    File tempFil = new File(inputFile + "temp.txt");
            
                    BufferedReader br2 = new BufferedReader (new FileReader("Readers.txt"));
                    PrintWriter Pwr2 = new PrintWriter(new FileWriter (tempFile));
                    String line2 = null;
            
                 //read from original, write to temporary and trim space, while title not found
                 while((line = br.readLine()) !=null) {
                     if(!line.trim().startsWith(name)){
                         Pwr2.println(line);
                         Pwr2.flush();
            
                     }
                 }
                    System.out.println("Book is not available right now :(");
                    Reader.loginReader();
                    
                    
                }
            }
              
                file.close();


    //s.close();
    }
    public static void Borrow() throws IOException
    {
        Scanner s = new Scanner(System.in);
        Book b = new Book();
        
        System.out.println("Enter the name 0f the Book: ");
        String name = s.nextLine();
        System.out.println("Enter the Start Date: ");
        String Start = s.nextLine();
        System.out.println("Enter the Due Date: ");
        String due = s.nextLine();
        Formatter x = null;
        File f = new File("Rented.txt");
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
    try {
        FileWriter r = new FileWriter("Rented.txt", true);
        x = new Formatter(r);
        x.format("%d %s %s %s%n",ID++,name);
        x.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
    String str =ID+" "+"Name: "+name+" "+"Start date: "+Start+" "+"Due Date: "+due;
     
              File r = new File("Rented.txt");
              Scanner file = new Scanner(f);
              int flag=0;
              while (file.hasNextLine()) {
                String data = file.nextLine();}
                File fileToBeModified = new File("Books.txt");
                // construct temporary file
                File inputFile = new File("Books.txt");
                File tempFile = new File(inputFile + "temp.txt");

                BufferedReader br = new BufferedReader (new FileReader("Books.txt"));
                PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
                String line = null;

            //read from original, write to temporary and trim space, while title not found
            while((line = br.readLine()) !=null) {
                if(line.trim().startsWith(name)){
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("Rented.txt", true)); 
                        out.write(ID+" "+"Name: "+name+" "+"Start date: "+Start+" "+"Due Date: "+due+"\n");
                        out.close();
                        
                      }
                    
                    catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                     
                    System.out.println("Payment Succeeded :)");
                    Reader.loginReader();
                }
                else{
                    File fileToBeModify = new File("Rented.txt");
                    // construct temporary file
                    File inputFil = new File("Rented.txt");
                    File tempFil = new File(inputFile + "temp.txt");
            
                    BufferedReader br2 = new BufferedReader (new FileReader("Readers.txt"));
                    PrintWriter Pwr2 = new PrintWriter(new FileWriter (tempFile));
                    String line2 = null;
            
                 //read from original, write to temporary and trim space, while title not found
                 while((line = br.readLine()) !=null) {
                     if(!line.trim().startsWith(name)){
                         Pwr2.println(line);
                         Pwr2.flush();
            
                     }
                 }
                    System.out.println("Book is not available right now :(");
                    Reader.loginReader();
                    
                    
                }
            }
              
                file.close();


    //s.close();

    }
    public void setId(int id)
    {
        ID = id;
    }
    public int getId()
    {
        return ID;
    }
}
