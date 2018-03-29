package sellerbuyer.util.database;

import sellerbuyer.bean.Buyer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BuyerTable {
    private static Map<Long, Buyer> buyers = new HashMap<>();

    public static Map<Long, Buyer> getBuyers() {
        return buyers;
    }
}
