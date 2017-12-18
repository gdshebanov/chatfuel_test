package chatfuel.utils;

import java.util.Scanner;

public class StringUtils {
    
    public static String checked;

    public static String userInput() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
    
    public static boolean hasNumber( String input ) {
        checked = input.replaceAll("\\D", "");
        return checked.length() > 0;
    }
    
    public static int getCheckedNumber() {
        return Math.abs( Integer.valueOf(checked) );
    }
    
    public static boolean chooseYes( String userInput ) {
        return userInput.equalsIgnoreCase("y");
    }
    
}
