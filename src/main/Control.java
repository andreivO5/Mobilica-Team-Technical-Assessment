/*
    Program Description: Mobilica Team Technical Assessment - Internships at Workhuman
    Author: Andrei Voiniciuc
    Date: 07/10/2023

 */

package main;

import java.util.*;

public class Control
{

    public static void main(String[] args)
    {
        // Filepath to the friends.txt file on my computer
        String path = "C:\\Users\\blaze\\Desktop\\oop_java\\Mobilica-Team-Technical-Assessment\\textfile\\friends.txt";
        // GPS coordinates to St. Stephen's Green park
        double stStephensLatitude =  53.337839;
        double stStephensLongitude = -6.259520;

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
        Friend[] friendList = friends.CreateFriendObjects();
        // A new list is created to store all the matchingFriends near St. Stephen's
        List<Friend> matchingFriends = new ArrayList<>();




        // note -- Include a "press Enter to start"
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Running the search process...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // for loop runs the SearchFriend method of each Friend in the .txt file
        for(int i = 0; i < friendList.length; i++)
        {
            // Matching friends are added to the list
            if (friendList[i].SearchFriend(stStephensLatitude,stStephensLongitude))
            {
                matchingFriends.add(friendList[i]);
            }
        }

        // note -- sort the array by userID

        System.out.println("Amount of matches: "+ matchingFriends.size());
        for (int i = 0; i < matchingFriends.size(); i++)
        {
            System.out.println("\nMatching Friend:\nUser ID: " + matchingFriends.get(i).getUser_id() + "\nName: " + matchingFriends.get(i).getName());
        }





    }
}