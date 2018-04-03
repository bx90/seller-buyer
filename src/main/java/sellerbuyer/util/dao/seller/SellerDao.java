package sellerbuyer.util.dao.seller;

import sellerbuyer.model.bean.Seller;

import java.util.List;

/**
 * @author bsun
 */
public interface SellerDao {
    List<Seller> getAll();
    Seller getById(Long id);
    Seller add(Seller seller);
}
