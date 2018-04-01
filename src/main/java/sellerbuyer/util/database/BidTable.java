package sellerbuyer.util.database;

import sellerbuyer.model.bean.Bid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BidTable {
    private static Map<Long, Bid> bids = new HashMap<>();

    public static Map<Long, Bid> getBids() {
        return bids;
    }
}
