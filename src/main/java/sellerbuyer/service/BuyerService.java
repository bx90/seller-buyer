package sellerbuyer.service;

import sellerbuyer.bean.Bid;
import sellerbuyer.bean.Buyer;
import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.BidManager;
import sellerbuyer.domain.manager.BuyerManager;
import sellerbuyer.domain.manager.ProjectManager;

import java.util.List;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class BuyerService {
    private ProjectManager projectManager = new ProjectManager();
    private BuyerManager buyerManager = new BuyerManager();
    private BidManager bidManager = new BidManager();

    public List<Project> getProjects() {
        return projectManager.getProject();
    }

    // add a bid in the project;
    // add a project in buyer.project.
    public void addBid(Bid bid, Long buyerId, Long projectId) {
        Project project = projectManager.getProject(projectId);
        Buyer buyer = buyerManager.getBuyer(buyerId);
        bidManager.addBid(bid);

        // TODO: notify seller.
        project.getBids().add(bid);
        buyer.getBids().add(bid);
    }
}
