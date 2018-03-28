package sellerbuyer.bean;

import sellerbuyer.domain.Observer;

import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Buyer implements Observer {
    private String buyerId;
    private List<Bid> bids;
    private List<Message> messageList;

    @Override
    public void update() {

    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
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
