package sellerbuyer.service;

import sellerbuyer.bean.Bid;
import sellerbuyer.bean.Buyer;
import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.BidManager;
import sellerbuyer.domain.manager.BuyerManager;
import sellerbuyer.domain.manager.ProjectManager;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
@Path("/")
public class BidService {
    private BidManager bidManager = new BidManager();
    private ProjectManager projectManager;
    private BuyerManager buyerManager;

    public BidService(ProjectManager projectManager, BuyerManager buyerManager) {
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
        project.getBids().add(bid);
        buyer.getBids().add(bid);
    }
}
