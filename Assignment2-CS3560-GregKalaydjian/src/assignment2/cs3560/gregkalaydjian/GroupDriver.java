package assignment2.cs3560.gregkalaydjian;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GroupDriver 
{
    //creating singleton class
    private static GroupDriver groupDriver_instance = null;
    public static GroupDriver getInstance()
    {
        if (groupDriver_instance == null)
        {
            groupDriver_instance = new GroupDriver();
        }
        return groupDriver_instance;
    }
    
    
    ArrayList<String> groupIDs = new ArrayList<String>();
   //recieve the UserID to an array of userIDs where it checks for duplicates
    
    //checking for duplicates
    protected boolean checkForDuplicateIDs(String groupID)
    {   
        
        for (int i = 0; i < groupIDs.size(); i++) 
        {
            if (groupID.equals(groupIDs.get(i)))
            {
                return true; //duplicate exists
            }
        }
        return false; //no duplicates
    }
    
    protected int addUserIDsToList(String groupID)
    {   
            groupIDs.add(groupID);
            return 1;
    }
    
    protected int getGroupTotal()
    {
        int groupTotal = 0;
        groupTotal = groupIDs.size();
        return groupTotal;
    }
}
