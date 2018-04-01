package sellerbuyer.util.time;

import sellerbuyer.util.exception.ValidationException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class TimeTransformer {

    public static ZonedDateTime getZonedDateTime(String input) throws ValidationException {
       LocalDateTime localDateTime = stringToLocalDateTime(input);
       return getLocalZonedDateTime(localDateTime);
    }

    private static LocalDateTime stringToLocalDateTime(String input) throws ValidationException {
        LocalDateTime ldt;
        try {
            ldt = LocalDateTime.parse(input);
        } catch (DateTimeParseException e) {
            throw new ValidationException(e.getMessage() + " Expected format: 2018-01-21T15:00");
        }
        return ldt;
    }

    private static ZonedDateTime getLocalZonedDateTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault());
    }
}
