package helper;

public class DoubleHelper {
    public static boolean checkDouble(String value)
    {
        try {
            Double.parseDouble(value);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

