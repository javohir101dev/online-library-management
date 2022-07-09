package helper;

public class IntegerHelper {
    public static boolean isDigit(String value) {
        try {
            int i = Integer.parseInt(value);
            if (i > -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
