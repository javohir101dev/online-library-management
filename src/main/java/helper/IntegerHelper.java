package helper;

public class IntegerHelper {
    public static boolean isDigit(String value)
    {
        try {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
