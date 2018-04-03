package sellerbuyer.util.dao.bid;

import sellerbuyer.model.bean.Bid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bsun
 */
public class BidInMemoryDao implements BidDao {
    private static Map<Long, Bid> bidTable = new HashMap<>();
    @Override
    public List<Bid> getAll() {
        return new ArrayList<>(bidTable.values());
    }

    @Override
    public Bid getById(Long id) {
        return bidTable.get(id);
    }

    @Override
    public Bid add(Bid bid) {
        Long id = (long) bidTable.size();
        bid.setBidId(id);
        bidTable.put(bid.getBidId(), bid);
        return bid;
    }
}
