package helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateHelper {

    /**
     * Returns null if given date cannot be parsed or inlaid otherwise java.util.Date
     * @param date
     * @return java.sql.Date
     */
    public static Date toSqlDate(java.util.Date date){
        if (date == null){
            return null;
        }
        return  new Date(date.getTime());
    }

    /**
     * Returns null if format cannot be parsed or inlaid otherwise java.util.Date
     * @param dateString
     * @return java.util.Date
     */
    public static java.util.Date toUtilDate(String dateString){
        if (dateString == null || dateString.length()== 0){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
             return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date toSqlDateFromString(String dateString){
        return toSqlDate(toUtilDate(dateString));
    }
}
