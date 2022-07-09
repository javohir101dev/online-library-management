package helper;

public class DoubleHelper {
    public static boolean checkDouble(String value)
    {
        try {
            double val = Double.parseDouble(value);
            if (val > -1){
                return true;
            }
            return false;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

