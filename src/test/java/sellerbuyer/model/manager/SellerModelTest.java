package sellerbuyer.model.manager;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;

import java.time.ZonedDateTime;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class SellerModelTest {
    private Project project1;
    private String description;
    private Long sellerId;
    SellerManager sellerManager;

    @BeforeTest
    public void setup() {
        sellerManager = ModelInitializer.getSellerManager();

        sellerId = 1L;
        description = "Test";
        project1 = new Project();
        populateProject(project1);
    }

    @Test
    public void getSellerFromManagerTest() {
        Seller seller = sellerManager.getSeller(1L);
        System.out.println(seller);
        Assert.assertNotNull(seller);
    }

    @Test
    public void linkProjectWithSellerTest() {
        sellerManager.linkProjectWithSeller(sellerId, project1);

        Assert.assertEquals(sellerManager.getSeller(sellerId).getProjectList().size(), 1);

    }

    private void populateProject(Project project) {
        project.setDescription(description);
        project.setBudget(100.0);
        project.setDueDate(ZonedDateTime.now());
    }
}
