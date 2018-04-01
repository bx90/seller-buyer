package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Project;
import sellerbuyer.util.database.BidTable;
import sellerbuyer.util.exception.ValidationException;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BidManager {
    private static Map<Long, Bid> bids = BidTable.getBids();

    public void addBid(Bid bid) {
        bid.setBidId(bids.size() + 1L);
        bid.setBidDate(ZonedDateTime.now());
        bids.put(bid.getBidId(), bid);
    }

    public void validate(Project project, Bid bid) throws ValidationException {
        if (project != null && project.getBids().containsKey(bid.getBuyerId())) {
            throw new ValidationException("You have bid the project for "
                    + project.getBids().get(bid.getBuyerId()));
        }


    }
}
