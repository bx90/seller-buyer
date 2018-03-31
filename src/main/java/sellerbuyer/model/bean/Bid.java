package sellerbuyer.model.bean;

import java.time.LocalDateTime;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Bid {
    private Long bidId;
    private Long buyerId;
    private String projectId;
    private Double price;
    private LocalDateTime bidData;
    private Buyer buyer;

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getBidData() {
        return bidData;
    }

    public void setBidData(LocalDateTime bidData) {
        this.bidData = bidData;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bid{");
        sb.append("bidId=").append(bidId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", projectId='").append(projectId).append('\'');
        sb.append(", price=").append(price);
        sb.append(", bidData=").append(bidData);
        sb.append(", buyer=").append(buyer);
        sb.append('}');
        return sb.toString();
    }
}
