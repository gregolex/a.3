package assignment2.cs3560.gregkalaydjian;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.time.ZonedDateTime;

public class UserDriver 
{
    //creating singleton class
    private static UserDriver userDriver_instance = null;
    public static UserDriver getInstance()
    {
        if (userDriver_instance == null)
        {
            userDriver_instance = new UserDriver();
        }
        return userDriver_instance;
    }
    
    class Observer1 implements Observer 
{ 
    public void update(Observable obj, Object arg) { } 
} 
    //public abstract void accept(Visitor v);

    
     ArrayList<String> userIDs = new ArrayList<String>();
     ArrayList<String> tempArrayList = new ArrayList<String>();
     ArrayList<String> tempTweetList = new ArrayList<String>();
     String[] profiles1 = new String[100]; //Don't hard code this for scalability in a real life scenario
     String[] following = new String[100]; //Don't hard code this for scalability in a real life scenario
     String[] profilesForTweets = new String[100]; //Don't hard code this for scalability in a real life scenario
     String[] tweets = new String[100]; //Don't hard code this for scalability in a real life scenario
     
     int profilesAndFollowingIndex;
     int profilesAndTweetIndex;
   //recieve the UserID to an array of userIDs where it checks for duplicates
    
    //checking for duplicates
    protected boolean checkForDuplicateIDs(String userID)
    {   
        
        for (int i = 0; i < userIDs.size(); i++) 
        {
            if (userID.equals(userIDs.get(i)))
            {
                return true; //duplicate exists
            }
        }
        return false; //no duplicates
    }
    
    protected int addUserIDsToList(String userID)
    {   
            userIDs.add(userID);
            return 1;
    }
    
    protected int getUserTotal()
    {
        int userTotal = 0;
        userTotal = userIDs.size();
        return userTotal;
    }
    
    protected boolean checkForUser(String selectedNode)
    {
        for (int i = 0; i < userIDs.size(); i++) 
        {
            if (selectedNode.equals(userIDs.get(i)))
            {
                return true; //user exists
            }
        }
        return false; //user does not exist
    }
    
    protected String getLastUser()
    {
        int lastIndex = userIDs.size();
        lastIndex = lastIndex - 1;
        String lastUser = userIDs.get(lastIndex);
        return lastUser;
    }
    
    protected void createProfile(String profile, String followUser)
    {
        profiles1[profilesAndFollowingIndex] = profile;
        following[profilesAndFollowingIndex] = followUser;
        profilesAndFollowingIndex++;
    }
    
    protected ArrayList<String> postTweet(String profile, String tweet)
    {
        profilesForTweets[profilesAndTweetIndex] = profile;
        tweets[profilesAndTweetIndex] = tweet;
        profilesAndTweetIndex++;
        
        
        for (int i = 0; i < profilesAndTweetIndex; i++)
        {
            if (profilesForTweets[i].equals(profile))
            {
                tempTweetList.add(tweets[i]);
            }
        }
        return tempTweetList;
    }
    
    protected ArrayList<String> checkFollowing(String profile)
    {
        for (int i = 0; i < profilesAndFollowingIndex; i++)
        {
            if (profiles1[i].equals(profile))
            {
                tempArrayList.add(following[i]);
            }
        }
        return tempArrayList;
    }
    
    protected void clearTempArray()
    {
        tempArrayList.clear();
        tempTweetList.clear();
    }
    
    protected int returnTweetAmount()
    {
        return profilesAndTweetIndex;
    }
    
    protected double returnPositivePercentage()
    {
        double percentPositive = 0;
        int positiveTweets = 0;
        int negativeTweets = 0;
        
        for (int i = 0; i < profilesAndTweetIndex; i++)
        {
            if (tweets[i].contains("Great!") || tweets[i].contains("Awesome") || tweets[i].contains("fantastic"))
                    {
                        positiveTweets++;
                    }
            else
            {
                    negativeTweets++;
            }
        }
        percentPositive = (positiveTweets / negativeTweets) * 50;
        return percentPositive;
    }
    
    protected boolean checkIDs()
    {
        boolean checkValid = true;
        String stringToBeChecked = "";
        for (int i = 0; i < userIDs.size(); i++)  
        {
            stringToBeChecked = userIDs.get(i);
            if (stringToBeChecked.contains(" "))
            {
                checkValid = false;
            }
        }
        return checkValid;
    }
    
    protected long setTime()
    {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("Current time in milliseconds" + time);
        return time;
        
    }
}

