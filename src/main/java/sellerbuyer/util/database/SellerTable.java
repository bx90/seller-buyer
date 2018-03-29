package sellerbuyer.util.database;

import sellerbuyer.bean.Seller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class SellerTable {

    private static Map<Long, Seller> sellers = new HashMap<>();

    public static Map<Long, Seller> getSellers() {
        return sellers;
    }
}
