package sellerbuyer.model.manager;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Buyer;

/**
 * @author Boxiong
 * @date 4/1/18
 **/
public class BuyerManagerTest {
    BuyerManager buyerManager;

    @BeforeTest
    public void setup() {
        buyerManager = new BuyerManager();
    }

    @Test
    public void getBuyerTest() {
        Buyer buyer = buyerManager.getBuyer(1L);
        Assert.assertNotNull(buyer);
    }
}
