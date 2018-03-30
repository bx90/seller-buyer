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
        Long buyerId1 = buyers.size() + 1L;
        Long buyerId2 = buyers.size() + 1L;

        Buyer buyer1 = new Buyer();
        Buyer buyer2 = new Buyer();

        buyer1.setBuyerId(buyerId1);
        buyer2.setBuyerId(buyerId2);

        buyers.put(buyer1.getBuyerId(), buyer1);
        buyers.put(buyer2.getBuyerId(), buyer2);
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
