
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Book {

    private float price;
    int Num_of_copies;
    private long isbn;
    String Title;
    String Author;
    String Location;
    String Genre;

    public static void addBook() throws IOException {
        Scanner sc = new Scanner(System.in);
        long isbn;
        int Num_of_copies;
        float price;
        String Title;
        String Author;
        String Location;
        String Genre;

        System.out.println("Enter Title: ");
        Title = sc.nextLine();
        System.out.println("Enter Author: ");
        Author = sc.nextLine();
        System.out.println("Enter Location: ");
        Location = sc.nextLine();
        System.out.println("Enter Genre: ");
        Genre = sc.nextLine();
        System.out.println("Enter ISBN: ");
        isbn = Long.parseLong(sc.nextLine());
        System.out.println("Enter Number of Copies: ");
        Num_of_copies = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Price: ");
        price = Float.parseFloat(sc.nextLine());

        Title = Title.trim();
        Author = Author.trim();
        Location = Location.trim();
        Genre = Genre.trim();
        String isbnStr = String.valueOf(isbn).trim();
        String Num_of_copiesStr = String.valueOf(Num_of_copies).trim();
        String priceStr = String.valueOf(price).trim();

        String x = "Title: " + Title + " " + "Author: " + Author + " " + "Location: " + Location + " " + "Genre: " + Genre + " " + "ISBN: " + isbnStr + " "
                + "Number of Copies: " + Num_of_copiesStr + " " + "Price: " + priceStr + " ";

        File f = new File("Books.txt");
        Scanner file = new Scanner(f);
        int flag = 0;
        while (file.hasNextLine()) {
            String data = file.nextLine();
            if (data.equals(x)) {
                System.out.println("Book Already Exist");
                flag = 1;
            }
        }
        if (flag == 0) {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("Books.txt", true));
                out.write("Title: " + Title + " " + "Author: " + Author + " " + "Location: " + Location + " " + "Genre: " + Genre + " " + "ISBN: " + isbnStr + " "
                        + "Number of Copies: " + Num_of_copiesStr + " " + "Price: " + priceStr + " " + "\n");
                out.close();
            } catch (IOException e) {
                System.out.println("exception occoured" + e);
            }

            System.out.println("Successfully Added");

        }
        file.close();

    }

    public static void Search() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Book Title: ");
        String bookTitle = sc.nextLine();

        bookTitle = bookTitle.trim();

        String x = "Title: " + bookTitle;
        try {
            File f = new File("Books.txt");
            Scanner content = new Scanner(f);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.contains(x)) {

                    System.out.print("\u001b[2J");
                    System.out.flush();
                    System.out.println("Book Found!\n");
                    //To be implemented
                    System.out.println(data);
                }
                if (flag == 0) {
                    System.out.println("Book Not Found!\n");
                }

            }
            content.close();
        } catch (FileNotFoundException e) {

            System.out.println("Error While Searching for your Book.");
        }
    }

    public static void deletBook() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Book Title: ");
        String bookTitle = sc.nextLine();

        bookTitle = bookTitle.trim();

        String title = "Title: " + bookTitle;
        try {
            File inputFile = new File("Readers.txt");
            File tempFile = new File(inputFile + "temp.txt");
            BufferedReader br = new BufferedReader(new FileReader("Readers.txt"));
            PrintWriter Pwr = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith(title)) {
                    continue;
                } else {
                    Pwr.println(line);
                    Pwr.flush();

                }
            }
            br.close();
            Pwr.close();
            inputFile.delete();
            if (tempFile.renameTo(inputFile)) {
                System.out.println("Update succesful");
            } else {
                System.out.println("Update failed");
            }

        } catch (FileNotFoundException e) {

            System.out.println("Error While Removing Book.");
        }
    }

    public static void DisplayInfo() throws IOException {
        try {
            File f = new File("Books.txt");
            Scanner content = new Scanner(f);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                System.out.print("\u001b[2J");
                System.out.flush();
                System.out.println(data);

            }
            content.close();
        } catch (FileNotFoundException e) {

            System.out.println("Error While Displaying Info.");
        }
    }

    public void setPrice(float p) {
        price = p;
    }

    public float getPrice() {
        return price;
    }

    public void setIsbn(long I) {
        isbn = I;
    }

    public float getIsbn() {
        return isbn;
    }

    public void display() {
        System.out.println("Title: " + Title + "\n" + "Pirce: " + getPrice() + "\n" + "Author: " + Author + "\n" + "ISBN: " + getIsbn() + "\n" + "Copies: " + Num_of_copies + "\n" + "Location: " + Location + "\n");
    }

}
