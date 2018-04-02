package sellerbuyer.model.bean;

import sellerbuyer.model.BuyerObservable;
import sellerbuyer.model.Observer;
import sellerbuyer.model.SellerObservable;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
@XmlRootElement
public class Project implements SellerObservable, BuyerObservable, Serializable {
    private Long projectId;
    private String description;
    private String userInputDueDate;
    private Long sellerId;
    private Boolean isActive;
    private Double budge;
    private ZonedDateTime dueDate;
    private ZonedDateTime createDate;
    private Map<Long, Bid> bids;
    private PriorityQueue<Bid> bidPriorityQueue;
    private Bid finalBid;
    private Double finalBidPrice;

    public Project() {
        bids = new HashMap<>();
        bidPriorityQueue = new PriorityQueue<>(Comparator.comparing(Bid::getPrice)
                                                         .thenComparing(Comparator.comparing(Bid::getBidDate)));
    }


    // Use priority queue.
    // insert O(logN), get O(1)
    public Bid getFinalBid() {
        finalBid = bidPriorityQueue.peek();
        return finalBid;
    }

    public void addBid(Bid bid) {
        bids.put(bid.getBuyerId(), bid);
        bidPriorityQueue.offer(bid);
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
//        bids.forEach(b -> b.getBuyer().update());
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

    public Map<Long, Bid> getBids() {
        return bids;
    }

    public void setBids(Map<Long, Bid> bids) {
        this.bids = bids;
    }

    public ZonedDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(ZonedDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUserInputDueDate() {
        return userInputDueDate;
    }

    public void setUserInputDueDate(String userInputDueDate) {
        this.userInputDueDate = userInputDueDate;
    }

    public void setFinalBid(Bid finalBid) {
        this.finalBid = finalBid;
    }

    public Double getFinalBidPrice() {
        return finalBidPrice == null ?
                (finalBid == null ? null : finalBid.getPrice()) : finalBidPrice;
    }

    public void setFinalBidPrice(Double finalBidPrice) {
        this.finalBidPrice = finalBidPrice;
    }

    public void setBidPriorityQueue(PriorityQueue<Bid> bidPriorityQueue) {
        this.bidPriorityQueue = bidPriorityQueue;
    }

    // Testing only
    //TODO: remove this before release

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Project{");
        sb.append("projectId=").append(projectId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", userInputDueDate='").append(userInputDueDate).append('\'');
        sb.append(", sellerId=").append(sellerId);
        sb.append(", isActive=").append(isActive);
        sb.append(", budge=").append(budge);
        sb.append(", dueDate=").append(dueDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", bids=").append(bids);
        sb.append(", bidPriorityQueue=").append(bidPriorityQueue);
        sb.append(", finalBid=").append(finalBid);
        sb.append(", finalBidPrice=").append(finalBidPrice);
        sb.append('}');
        return sb.toString();
    }
}
