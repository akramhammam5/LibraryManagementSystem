/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laibraryproject;

import java.lang.reflect.Member;
import java.util.Scanner;


public class Librarian {

    

        public String name;
        private int ID;
    
        public void Welcome()
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("\u001b[2J");
            System.out.flush();
            System.out.println("\t\t              Welcome To LibraryManagementSystem :)           \n\n");
            System.out.println("you are a Librarian What do you'd like to do today :) ?");
            System.out.println("1- Add User\n2- Add Books\n3- Logout :(\n");
            int choice = scan.nextShort();

        switch(choice){
            case 3:
            { 
            System.out.print("\u001b[2J");
            System.out.flush();
            System.out.println("Logged Out!\n\n\n");
            Registeration R = new Registeration();
            R.register();
            break;
            }
            default:
            {
                System.out.println("Invalid Choice");
            }
        }
            
        
        }
        public void AddUser(Scanner sc){
            System.out.println("Enter Your Name");
            String title=sc.next();
            int j = 0;
            User user =new User(title,j+1);
            User[] users = null;
            users[j]=user;
            j++;
            System.out.println("User Added ID:"+users[j-1].getID());       
    
    }
    public void RemoveUser(int ID,String username){
        
    
    }
    public void Block(){
    
    
    }
    public String SearchUser(){
        
        
        return null;
        
        
    }
   public String Rent(){
      
       
       
       
        return null;
       
       
   }
   public String PrintBill(Scanner sc){
       /*int fine;
       int bill=100;
       System.out.println("Enter Member ID");
       int id=sc.nextInt();
        members[] member=new members[id-1];
        if(member.getIssued)>0){
           Book[] books = null;
            Book book=books[member.getIssued()];
            fine=new Fine(book.getIssuedDte(),book.getReturnDate()).getFine();
           
   }else{
            fine=0;
        }
        bill+=fine;
        System.out.println("Bill Amount is:"+bill);
        return null;
        
               
   }*/

    private static class members {

        public members() {
        }
    }
           
   }
}

