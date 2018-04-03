package sellerbuyer.model.observer;

import sellerbuyer.model.bean.Message;

/**
 * @author Boxiong
 * @date 3/27/18
 *
 * Item like project is observable
 **/

public interface SellerObservable {
//    void addSeller(Observer o);
//    void removeSeller(Observer o);
    void notifySeller(Message message);
}
