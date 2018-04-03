package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;
import sellerbuyer.util.dao.seller.SellerDao;
import sellerbuyer.util.dao.seller.SellerInMemoryDao;
import sellerbuyer.util.exception.ValidationException;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class SellerManager {
    private SellerDao sellerDao = new SellerInMemoryDao();

    public SellerManager() {
        Seller seller1 = new Seller();
        Seller seller2 = new Seller();
        Seller seller3 = new Seller();

        sellerDao.add(seller1);
        sellerDao.add(seller2);
        sellerDao.add(seller3);
    }

    public Seller getSeller(Long id) {
        return sellerDao.getById(id);
    }

    public void linkProjectWithSeller(Long sellerId, Project project) {
        sellerDao.getById(sellerId).getProjectList().add(project);
    }

    public void validate(Long id) throws ValidationException {
        if (sellerDao.getById(id) == null) {
            throw new ValidationException("Cannot find seller with id: " + Long.toString(id) + ".");
        }
    }

}
