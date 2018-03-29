package sellerbuyer.bean;

import sellerbuyer.domain.BuyerObservable;
import sellerbuyer.domain.Observer;
import sellerbuyer.domain.SellerObservable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Project implements SellerObservable, BuyerObservable {
    private Long projectId;
    private String description;
    private Long sellerId;
    private Double budge;
    private Date dueDate;
    private List<Bid> bids;
    private Seller seller;

    public Project() {
        bids = new ArrayList<>();
    }

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Testing only
    //TODO: remove this before release
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Project{");
        sb.append("projectId=").append(projectId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", sellerId='").append(sellerId).append('\'');
        sb.append(", budge=").append(budge);
        sb.append(", dueDate=").append(dueDate);
        sb.append(", bids=").append(bids);
        sb.append(", seller=").append(seller);
        sb.append('}');
        return sb.toString();
    }
}
