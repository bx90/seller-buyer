package sellerbuyer.bean;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class ProjectTest {
    private Bid bid1;
    private Bid bid2;

    @BeforeTest
    public void setup() {
        bid1 = new Bid();
        bid2 = new Bid();

    }
    @Test
    public void compareBidPriceDiff() {
        bid1.setPrice(100.0);
        bid2.setPrice(300.0);

        bid1.setBidData(LocalDateTime.now());
        bid2.setBidData(LocalDateTime.now().minusDays(1));

        Project project = new Project();
        project.addBid(bid1);
        project.addBid(bid2);

        System.out.println(project.getFinalBid());
        Assert.assertEquals(project.getFinalBid().getPrice(), 100.0);
    }

    @Test
    public void samePriceDiffDate() {
        bid1.setPrice(100.0);
        bid2.setPrice(100.0);

        bid1.setBidData(LocalDateTime.now().minusDays(1));
        bid2.setBidData(LocalDateTime.now());

        Project project = new Project();
        project.addBid(bid1);
        project.addBid(bid2);

        System.out.println(project.getFinalBid());
        Assert.assertEquals(project.getFinalBid().getPrice(), 100.0);
    }
}
