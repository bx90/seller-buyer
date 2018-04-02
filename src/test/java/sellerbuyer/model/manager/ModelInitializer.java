package sellerbuyer.model.manager;

import sellerbuyer.model.manager.BidManager;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.model.manager.SellerManager;

/**
 * @author Boxiong
 * @date 4/1/18
 **/
public class ModelInitializer {
    private static SellerManager sellerManager = new SellerManager();
    private static BuyerManager buyerManager = new BuyerManager();
    private static ProjectManager projectManager = new ProjectManager();
    private static BidManager bidManager = new BidManager();

    public static SellerManager getSellerManager() {
        return sellerManager;
    }

    public static BuyerManager getBuyerManager() {
        return buyerManager;
    }

    public static ProjectManager getProjectManager() {
        return projectManager;
    }

    public static BidManager getBidManager() {
        return bidManager;
    }
}
