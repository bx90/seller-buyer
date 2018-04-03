package sellerbuyer.model.bean;

import sellerbuyer.model.observer.Observer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
@XmlRootElement
public class Seller extends Role implements Observer {

    private Long sellerId;
    private List<Project> projectList;
    private List<Message> messageList;
    private List<Link> links;

    public Seller() {
        links = new ArrayList<>();
        projectList = new ArrayList<>();
        messageList = new ArrayList<>();
    }

    @Override
    public void update(Message message) {
        messageList.add(message);
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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
