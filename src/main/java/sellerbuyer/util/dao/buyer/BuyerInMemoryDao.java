package sellerbuyer.util.dao.buyer;

import sellerbuyer.model.bean.Buyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bsun
 */
public class BuyerInMemoryDao implements BuyerDao {
    private static Map<Long, Buyer> buyerTable = new HashMap<>();
    @Override
    public List<Buyer> getAll() {
        return new ArrayList<>(buyerTable.values());
    }

    @Override
    public Buyer getById(Long id) {
        return buyerTable.get(id);
    }

    @Override
    public Buyer add(Buyer buyer) {
        Long id = (long) buyerTable.size();
        buyer.setBuyerId(id);
        buyerTable.put(buyer.getBuyerId(), buyer);
        return buyer;
    }
}
