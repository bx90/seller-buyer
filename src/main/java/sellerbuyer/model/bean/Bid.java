package sellerbuyer.model.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZonedDateTime;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
@XmlRootElement
public class Bid {
    private Long bidId;
    private Long buyerId;
    private Long projectId;
    private Double price;
    private ZonedDateTime bidDate;
//    private Buyer buyer;

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ZonedDateTime getBidDate() {
        return bidDate;
    }

    public void setBidDate(ZonedDateTime bidData) {
        this.bidDate = bidData;
    }

//    public Buyer getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(Buyer buyer) {
//        this.buyer = buyer;
//    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bid{");
        sb.append("bidId=").append(bidId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", projectId='").append(projectId).append('\'');
        sb.append(", price=").append(price);
        sb.append(", bidDate=").append(bidDate);
//        sb.append(", buyer=").append(buyer);
        sb.append('}');
        return sb.toString();
    }
}
