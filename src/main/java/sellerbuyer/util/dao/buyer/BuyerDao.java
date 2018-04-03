package sellerbuyer.util.dao.buyer;

import sellerbuyer.model.bean.Buyer;

import java.util.List;

/**
 * @author bsun
 */
public interface BuyerDao {
    List<Buyer> getAll();
    Buyer getById(Long id);
    Buyer add(Buyer buyer);
}
