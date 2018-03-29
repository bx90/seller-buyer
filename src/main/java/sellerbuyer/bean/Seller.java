package sellerbuyer.bean;

import sellerbuyer.domain.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Seller implements Observer {

    private Long sellerId;
    private List<Project> projectList;
    private List<Message> messageList;

    public Seller() {
        projectList = new ArrayList<>();
        messageList = new ArrayList<>();
    }

    @Override
    public void update() {

    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
