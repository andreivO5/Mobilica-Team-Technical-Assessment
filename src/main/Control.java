/*
    Program Description: Mobilica Team Technical Assessment - Internships at Workhuman
    Author: Andrei Voiniciuc
    Date: 07/10/2023

 */

package main;

public class Control
{

    public static void main(String[] args)
    {
        // Filepath to the friends.txt file on my computer
        String path = "C:\\Users\\blaze\\Desktop\\oop_java\\Mobilica Team Technical Assessment\\textfile\\friends.txt";

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the Friends Record Program");
        System.out.println("Developed by: Andrei Voiniciuc");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("This program will output all the names and UserID's of friends");
        System.out.println("in a 100km radius of St Stephen's Green park, using records in");
        System.out.println("the friends.txt text file.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // FileProcessor object for friends.txt is created using path
        FileProcessor friends = new FileProcessor(path);
        // CreateFriendObjects method run
        friends.CreateFriendObjects();



    }
}