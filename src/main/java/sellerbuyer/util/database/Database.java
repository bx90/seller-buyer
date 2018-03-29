package sellerbuyer.util.database;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public interface Database <T> {
    Map<Long, T> getData();
}
