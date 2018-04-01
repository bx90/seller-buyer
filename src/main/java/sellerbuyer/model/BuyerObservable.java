package sellerbuyer.model;

/**
 * @author Boxiong
 * @date 3/27/18
 *
 * Item like project is observable
 **/

public interface BuyerObservable {
    void addBuyer(Observer o);
    void removeBuyer(Observer o);
    void notifyBuyer();
}
