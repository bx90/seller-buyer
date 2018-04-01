package sellerbuyer.model.bean;

import sellerbuyer.model.Observer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
@XmlRootElement
public class Buyer implements Observer {
    private Long buyerId;
    private List<Bid> bids;
    private List<Message> messageList;


    public Buyer() {
        bids = new ArrayList<>();
        messageList = new ArrayList<>();
    }

    @Override
    public void update() {

    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
