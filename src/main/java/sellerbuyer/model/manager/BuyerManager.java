package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Buyer;
import sellerbuyer.util.dao.buyer.BuyerDao;
import sellerbuyer.util.dao.buyer.BuyerInMemoryDao;
import sellerbuyer.util.exception.ValidationException;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BuyerManager {
    private BuyerDao buyerDao = new BuyerInMemoryDao();

    public BuyerManager() {
        Buyer buyer1 = new Buyer();
        Buyer buyer2 = new Buyer();
        buyerDao.add(buyer1);
        buyerDao.add(buyer2);
    }

    public Buyer getBuyer(Long id) {
        return buyerDao.getById(id);
    }

    public void validate(Long buyerId) throws ValidationException {
        if (buyerDao.getById(buyerId) == null) {
            throw new ValidationException("Buyer with id: " + Long.toString(buyerId) + " does not exist.");
        }
    }
}
