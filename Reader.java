/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.laibraryproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;



public class Reader {
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
