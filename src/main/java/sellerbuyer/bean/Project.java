package sellerbuyer.bean;

import sellerbuyer.domain.BuyerObservable;
import sellerbuyer.domain.Observer;
import sellerbuyer.domain.SellerObservable;

import java.util.Date;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Project implements SellerObservable, BuyerObservable {
    private String projectId;
    private String description;
    private String sellerId;
    private Double budge;
    private Date dueDate;
    private List<Bid> bids;
    private Seller seller;


    // Use priority queue.
    // insert O(logN), get O(1)
    public String getFinalBid() {
        return null;
    }


    @Override
    public void notifySeller() {

    }

    @Override
    public void addBuyer(Observer o) {

    }

    @Override
    public void removeBuyer(Observer o) {

    }

    @Override
    public void notifyBuyer() {
        bids.forEach(b -> b.getBuyer().update());
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Double getBudge() {
        return budge;
    }

    public void setBudge(Double budge) {
        this.budge = budge;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
