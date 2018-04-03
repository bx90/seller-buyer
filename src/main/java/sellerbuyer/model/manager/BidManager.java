package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Project;
import sellerbuyer.util.dao.bid.BidDao;
import sellerbuyer.util.dao.bid.BidInMemoryDao;
import sellerbuyer.util.exception.ValidationException;

import java.time.ZonedDateTime;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class BidManager {
    //    private static Map<Long, Bid> bids = BidTable.getBids();
    private BidDao bidDao = new BidInMemoryDao();

    public void addBid(Bid bid) {
//        bid.setBidId(bids.size() + 1L);
        bid.setBidDate(ZonedDateTime.now());
//        bids.put(bid.getBidId(), bid);
        bidDao.add(bid);
    }

    public void validate(Project project, Bid bid) throws ValidationException {
        if (project != null && project.getBids().containsKey(bid.getBuyerId())) {
            throw new ValidationException("You have bid the project for "
                    + project.getBids().get(bid.getBuyerId()));
        }

        if (bid.getPrice() == null) {
            throw new ValidationException("Bid price is a mandatory field. Please provide a valid number.");
        }

        if (project != null && bid.getPrice() > project.getBudget()) {
            throw new ValidationException("Your bid price is above the project budget.");
        }

    }
}
