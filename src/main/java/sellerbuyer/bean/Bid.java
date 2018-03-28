package sellerbuyer.bean;

import java.util.Date;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Bid {
    private String bidId;
    private String buyerId;
    private String projectId;
    private Double price;
    private Date bidData;
    private Buyer buyer;

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
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

    public Date getBidData() {
        return bidData;
    }

    public void setBidData(Date bidData) {
        this.bidData = bidData;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
