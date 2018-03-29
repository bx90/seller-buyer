package sellerbuyer.domain.manager;

import sellerbuyer.bean.Bid;
import sellerbuyer.util.database.BidTable;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BidManager {
    private static Map<Long, Bid> bids = BidTable.getBids();

    public void addBid(Bid bid) {
        bid.setBidId(bids.size() + 1L);
        bids.put(bid.getBidId(), bid);
    }
}
