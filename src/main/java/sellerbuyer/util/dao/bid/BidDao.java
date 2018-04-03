package sellerbuyer.util.dao.bid;

import sellerbuyer.model.bean.Bid;

import java.util.List;

/**
 * @author bsun
 */
public interface BidDao {
    List<Bid> getAll();
    Bid getById(Long id);
    Bid add(Bid bid);
}
