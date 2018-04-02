package sellerbuyer.model;

import sellerbuyer.model.bean.Message;

/**
 * @author Boxiong
 * @date 3/27/18
 **/
public interface Observer {
    void update(Message message);
}
