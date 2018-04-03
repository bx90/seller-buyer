package sellerbuyer.util.dao.seller;

import sellerbuyer.model.bean.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bsun
 */
public class SellerInMemoryDao implements SellerDao {
    private static Map<Long, Seller> sellerTable = new HashMap<>();
    @Override
    public List<Seller> getAll() {
        return new ArrayList<>(sellerTable.values());
    }

    @Override
    public Seller getById(Long id) {
        return sellerTable.get(id);
    }

    @Override
    public Seller add(Seller seller) {
        Long id = (long) sellerTable.size();
        seller.setSellerId(id);
        sellerTable.put(seller.getSellerId(), seller);
        return seller;
    }
}
