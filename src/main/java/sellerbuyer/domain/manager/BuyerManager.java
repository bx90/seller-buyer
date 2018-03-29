package sellerbuyer.domain.manager;

import sellerbuyer.bean.Buyer;
import sellerbuyer.util.database.BuyerTable;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BuyerManager {
    private Map<Long, Buyer> buyers = BuyerTable.getBuyers();

    public BuyerManager() {
        buyers.put(buyers.size() + 1L, new Buyer());
        buyers.put(buyers.size() + 1L, new Buyer());
    }

    public Buyer addBuyer(Buyer buyer) {
        buyer.setBuyerId((long) buyers.size() + 1);
        buyers.put(buyer.getBuyerId(), buyer);
        return buyer;
    }

    public Buyer getBuyer(Long id) {
        return buyers.get(id);
    }
}
