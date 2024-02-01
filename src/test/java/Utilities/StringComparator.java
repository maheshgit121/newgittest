package Utilities;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
	
	public int compare(String s1, String s2) 
    { 
        if (s1.equals(s2)) 
            return 0; 
        else 
            return s1.compareTo(s2); 
        
    } 

}
