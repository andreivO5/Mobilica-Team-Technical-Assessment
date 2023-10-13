package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// importing JSON library for text file processing
import org.json.JSONObject;


public class FileProcessor
{
    public String filepath;

    // Constructor for FileProcessor object
    public FileProcessor(String filepath) {
        this.filepath = filepath;
    }

    // method to create an array of the Friend objects
    public Friend[] CreateFriendObjects()
    {
        // Creating a Friend array to hold the new Friend objects
        Friend[] friendList = new Friend[0];
        try
        {
            // create file from filepath
            File friends = new File(filepath);
            // using scanner to read the text file
            Scanner textScanner = new Scanner(friends);
            // creating a list of strings to hold each individual line in friends.txt
            List<String> lineList = new ArrayList<>();

            while (textScanner.hasNextLine()) {
                // adding each line to the lineList
                lineList.add(textScanner.nextLine());
            }

            // Assigning size to the array
            friendList = new Friend[lineList.size()];

            for (int i = 0; i < lineList.size(); i++)
            {
                // JSON objects are created from each line in lineList
                JSONObject temp = new JSONObject(lineList.get(i));
                // attributes are initialised with the appropriate value
                double latitude = temp.getDouble("latitude");
                int userId = temp.getInt("user_id");
                String name = temp.getString("name");
                double longitude = temp.getDouble("longitude");

                // the Friend object is constructed with the attributes and added to the friendList array
                friendList[i] = new Friend(userId, name, latitude, longitude);
            }
        } catch (FileNotFoundException e) {
            // error checking for file reading.
            System.out.println("Error reading friends.txt");
            e.printStackTrace();
        }
        // returning the array
        return friendList;
    }

}
