package sellerbuyer.model.bean;

import java.util.Date;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public class Message {
    private String messageId;
    private Boolean isUnread;
    private String content;
    private Date createDate;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Boolean getUnread() {
        return isUnread;
    }

    public void setUnread(Boolean unread) {
        isUnread = unread;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
