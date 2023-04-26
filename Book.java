
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Book {
   private float price;
   int Num_of_copies;
   private long isbn;
   String Title;
   String Author;
   String Location;
   String Genre;

   public void setPrice(float p)
   {
        price = p;
   }
   public float getPrice()
   {
        return price;
   }
   public void setIsbn(long I)
   {
        isbn = I;
   }
   public float getIsbn()
   {
        return isbn;
   }

}