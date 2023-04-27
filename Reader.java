/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.laibraryproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;



public class Reader {
    public static void loginReader() throws IOException
    {

      
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
       
         
        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();

        Uname=Uname.trim();
        Pass=Pass.trim();

        String x ="Name: "+Uname+" "+"Password: "+Pass;

        try {
            Scanner s = new Scanner(System.in);
            File f = new File("Readers.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
              String data = content.nextLine();
              if(data.equals(x))
              {
                  System.out.print("\u001b[2J");
                  System.out.flush();
                  System.out.println("Welcome Reader! What do you want to do today:) ?\n");
                  System.out.println("1-Search for a book\n2-Search for a user\n3-Rent a book\n4-Buy a book\n5-Logout\n");
                  int choice=s.nextInt();

                  switch(choice)
                  {
                    case 1:
                    {
                        System.out.print("\u001b[2J");
                        System.out.flush();
                        Librarian.SearchBook();
                        break;
                    }
                    case 2:
                    {
                        System.out.print("\u001b[2J");
                        System.out.flush();
                        Librarian.searchUser();
                        break;
                    }
                    case 3:
                    {
                        System.out.print("\u001b[2J");
                        System.out.flush();
                        Request.Borrow();
                        break;
                    }
                    case 4:
                    {
                      System.out.print("\u001b[2J");
                      System.out.flush();
                      Request.Buy();
                      break;
                    }
                    case 5:
                    {
                      System.out.print("\u001b[2J");
                      System.out.flush();
                      System.out.println("Logged Out!\n\n\n");
                      Main R = new Main();
                      R.main(null);
                      break;
                    }

                  }
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
