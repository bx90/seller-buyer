package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Seller;
import sellerbuyer.util.database.SellerTable;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class SellerManager {
    private Map<Long, Seller> sellers = SellerTable.getSellers();

    public SellerManager() {
        Long id1 = sellers.size() + 1L;
        Seller seller1 = new Seller();
        seller1.setSellerId(id1);

        Long id2 = sellers.size() + 1L;
        Seller seller2 = new Seller();
        seller2.setSellerId(id2);

        sellers.put(seller1.getSellerId(), seller1);
        sellers.put(seller2.getSellerId(), seller2);
    }

    public Seller addSeller(Seller seller) {
        seller.setSellerId((long) sellers.size() + 1);
        sellers.put(seller.getSellerId(), seller);
        return seller;
    }

    public Seller getSeller(Long id) {
        return sellers.get(id);
    }

}
