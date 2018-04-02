package sellerbuyer.controller;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Project;

import java.util.List;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class BuyerControllerTest {
    private Project project1;
    @BeforeTest
    public void setup() {
        project1 = new Project();
        project1.setDescription("Test");
        project1.setBudge(100.0);
    }

    @Test
    public void testGetBuyer() {

    }
    @Test
    public void testGetProjects() throws Exception {
        BuyerController buyerService = new BuyerController();
        SellerController sellerService = new SellerController();

//        sellerService.addProject(project1, 1L);
//        List<Project> projectList = buyerService.getProjects();

        Bid bid = new Bid();
        bid.setPrice(200.0);

//        buyerService.addBid(bid, 1L, 1L);

//        System.out.println(projectList.get(0).toString());
    }
}