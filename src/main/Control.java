/*
    Program Description: Mobilica Team Technical Assessment - Internships at Workhuman

    Using "friends" records in a friends.txt file, this program reads the full list of friends
    and outputs the names and user ids of every friend within 100km of St. Stephen's Green park,
    using the great-circle distance and Haversine formula.

    This program uses 3 classes, with the main processes running in the Control class, the file
    related processes are done in the FileProcessor class, and a Friend class is used to create
    Friend objects that are used, alongside with the primary SearchFriend function.

    Author: Andrei Voiniciuc
    Date: 13/10/2023
 */

package main;

import java.util.*;

public class Control
{
    public static void main(String[] args)
    {
        // Filepath to the friends.txt file on my computer
        // Please replace with your own path to the friends.txt file.
        String path = "C:\\Users\\blaze\\Desktop\\oop_java\\Mobilica-Team-Technical-Assessment\\textfile\\friends.txt";
        // GPS coordinates to St. Stephen's Green park, provided in the assessment document
        double stStephensLatitude =  53.337839;
        double stStephensLongitude = -6.259520;

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the Friends Record Program");
        System.out.println("Developed by: Andrei Voiniciuc");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("This program will output all the names and UserID's of friends");
        System.out.println("in a 100km radius of St Stephen's Green park, using records in");
        System.out.println("the friends.txt text file.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Press Enter to start searching...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        scanner.nextLine(); // This will wait for the Enter key press.

        // FileProcessor object for friends.txt is created using path
        FileProcessor friends = new FileProcessor(path);
        // CreateFriendObjects method run
        Friend[] friendList = friends.CreateFriendObjects();
        // A new list is created to store all the matchingFriends near St. Stephen's
        List<Friend> matchingFriends = new ArrayList<>();

        // for loop runs the SearchFriend method of each Friend in the .txt file
        for (Friend friend : friendList) {
            // Matching friends are added to the list
            if (friend.SearchFriend(stStephensLatitude, stStephensLongitude)) {
                matchingFriends.add(friend);
            }
        }

        // Creating a comparator to sort the matching friends by user_id
        Comparator<Friend> userIdComparator = (friend1, friend2) -> {
            if (friend1.getUser_id() < friend2.getUser_id()) {
                return -1;
            } else if (friend1.getUser_id() > friend2.getUser_id()) {
                return 1;
            } else {
                return 0;
            }
        };
        // Sorting the array using the comparator
        Collections.sort(matchingFriends, userIdComparator);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Friends within 100km of St. Stephen's Green Park:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Printing the matching friends
        for (Friend matchingFriend : matchingFriends) {
            System.out.println("\nUser ID: " + matchingFriend.getUser_id() +
                    "\nName: " + matchingFriend.getName());
        }

        scanner.close(); // Closing the Enter scanner.
    }
}