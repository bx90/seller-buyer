package sellerbuyer.model.datacollection.project;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Project;

import java.time.ZonedDateTime;


/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class ProjectCollectionStrategyTest {
    private Project project1;
    private ProjectCollector projectCollector = new ProjectCollector();
    @BeforeTest
    public void setup() {
        project1 = new Project();
        project1.setProjectId(1L);

        Bid bid = new Bid();
        bid.setBuyerId(1L);
        bid.setPrice(200.0);

        bid.setBidDate(ZonedDateTime.now());
        project1.addBid(bid);
    }
    // Buyer should not see the bid list.
    @Test
    public void testBuyerCollection() {
        projectCollector.setProjectCollectionStrategy(new SellerProjectCollection());
        Project result = projectCollector.collect(project1);
        System.out.println(result.getFinalBid());
        System.out.println(result);
        Assert.assertNull(result.getBids());
    }

    // Seller should not see the bid list.
    @Test
    public void testSellerCollection() {
        projectCollector.setProjectCollectionStrategy(new BuyerProjectCollection());
        Project result = projectCollector.collect(project1);
        System.out.println(result);
        Assert.assertNull(result.getBids());
    }



}