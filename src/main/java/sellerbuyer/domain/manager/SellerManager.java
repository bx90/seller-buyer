package sellerbuyer.domain.manager;

import sellerbuyer.bean.Seller;
import sellerbuyer.util.database.SellerTable;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class SellerManager {
    private Map<Long, Seller> sellers = SellerTable.getSellers();

    public SellerManager() {
        sellers.put(sellers.size() + 1L, new Seller());
        sellers.put(sellers.size() + 1L, new Seller());
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
