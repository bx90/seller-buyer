package sellerbuyer.controller;

import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Buyer;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.manager.BidManager;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
@Path("/")
public class BidController {
    private BidManager bidManager = new BidManager();
    private ProjectManager projectManager;
    private BuyerManager buyerManager;

    public BidController(ProjectManager projectManager, BuyerManager buyerManager) {
        this.projectManager = projectManager;
        this.buyerManager = buyerManager;
    }

    // add a bid in the project;
    // add a project in buyer.project.
    @POST
    public void addBid(Bid bid,
                       @PathParam("buyerId") Long buyerId,
                       @PathParam("projectId") Long projectId) {
        Project project = projectManager.getProject(projectId);
        Buyer buyer = buyerManager.getBuyer(buyerId);
        bidManager.addBid(bid);

        // TODO: notify seller.
        project.addBid(bid);
        buyer.getBids().add(bid);
    }
}
