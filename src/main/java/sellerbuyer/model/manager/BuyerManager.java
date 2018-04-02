package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Buyer;
import sellerbuyer.util.database.BuyerTable;
import sellerbuyer.util.exception.ValidationException;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BuyerManager {
    private Map<Long, Buyer> buyers = BuyerTable.getBuyers();

    public BuyerManager() {
        Long buyerId1 = (long) buyers.size();
        Buyer buyer1 = new Buyer();
        buyer1.setBuyerId(buyerId1);
        buyers.put(buyer1.getBuyerId(), buyer1);

        Long buyerId2 = (long) buyers.size();
        Buyer buyer2 = new Buyer();
        buyer2.setBuyerId(buyerId2);
        buyers.put(buyer2.getBuyerId(), buyer2);
    }

    public Buyer getBuyer(Long id) {
        return buyers.get(id);
    }

    public void validate(Long buyerId) throws ValidationException {
        if (buyers.get(buyerId) == null) {
            throw new ValidationException("Buyer with id: " + Long.toString(buyerId) + " does not exist.");
        }
    }
}
