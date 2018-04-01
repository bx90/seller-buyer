package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;
import sellerbuyer.util.database.SellerTable;
import sellerbuyer.util.exception.ValidationException;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class SellerManager {
    private Map<Long, Seller> sellers = SellerTable.getSellers();

    public SellerManager() {
        Long id1 = (long) sellers.size();
        Seller seller1 = new Seller();
        seller1.setSellerId(id1);
        sellers.put(seller1.getSellerId(), seller1);

        Long id2 = (long) sellers.size();
        Seller seller2 = new Seller();
        seller2.setSellerId(id2);

        sellers.put(seller2.getSellerId(), seller2);
    }

    public Seller getSeller(Long id) {
        return sellers.get(id);
    }

    public void linkProjectWithSeller(Long sellerId, Project project) {
        sellers.get(sellerId).getProjectList().add(project);
    }

    public void validate(Long id) throws ValidationException {
        if (sellers.get(id) == null) {
            throw new ValidationException("Cannot find seller with id: " + Long.toString(id) + ".");
        }
    }

}
