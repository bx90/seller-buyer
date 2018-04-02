package sellerbuyer.controller;

import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Buyer;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.manager.BidManager;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.util.exception.ValidationException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
@Path("/")
public class BidController {
    private static BidManager bidManager;

    static {
        bidManager = new BidManager();
    }

    private ProjectManager projectManager;
    private BuyerManager buyerManager;

    public BidController(ProjectManager projectManager, BuyerManager buyerManager) {
        this.projectManager = projectManager;
        this.buyerManager = buyerManager;
    }

    @POST
    public Bid addBid(Bid bid,
                      @PathParam("buyerId") Long buyerId,
                      @PathParam("projectId") Long projectId) throws ValidationException {
        Project project = projectManager.getProject(projectId);

        bid.setProjectId(projectId);
        bid.setBuyerId(buyerId);
        bid.setBidDate(ZonedDateTime.now());

        Buyer buyer = buyerManager.getBuyer(buyerId);
        bidManager.addBid(bid);
        bidManager.validate(project, bid);
        // TODO: notify seller.

        project.addBid(bid);
        buyer.getBids().add(bid);

        return bid;
    }

}
