package helper;

public class StringHelper {

    public static boolean isValid(String s){
        return s != null && s.trim().length() > 0;
    }

}
