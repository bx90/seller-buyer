package sellerbuyer.service;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.bean.Project;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class SellerServiceTest {
    private Project project1;
    private long projectId;
    private String description;
    @BeforeTest
    public void setup() {
        description = "Test";
        projectId = (long)1;

        project1 = new Project();
        project1.setDescription(description);
        project1.setBudge(100.0);
    }
    @Test
    public void testGetProjects() throws Exception {
        SellerService sellerService = new SellerService();
        sellerService.addProject(project1);
        System.out.println(sellerService.getProject(projectId));
        Assert.assertNotNull(sellerService.getProject(projectId), "Cannot get project with given project id: " + projectId + ".");
        Assert.assertTrue(sellerService.getProject(projectId).getDescription().equals(description),
                        "The project description is NOT correct. Expecting " + description + ". But get " + sellerService.getProject(projectId).getDescription());
    }
}
