package sellerbuyer.controller;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;
import sellerbuyer.util.database.SellerTable;

import java.util.Map;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class SellerServiceTest {
    private Project project1;
    private long projectId;
    private String description;
    private Long sellerId;
    SellerController sellerService;
    ProjectController projectService;
    @BeforeTest
    public void setup() {
        sellerService = new SellerController();
//        projectService = new ProjectController();

        sellerId = 1L;
        description = "Test";
        projectId = (long)1;

        project1 = new Project();
        populateProject(project1);
    }

//    @Test
//    public void getProjectsTest() throws Exception {
//        sellerService.addProject(project1, sellerId);
//
//        System.out.println(sellerService.getProject(projectId, sellerId));
//        Assert.assertNotNull(sellerService.getProject(projectId, sellerId), "Cannot get project with given project id: " + projectId + ".");
//        Assert.assertTrue(sellerService.getProject(projectId, sellerId).getDescription().equals(description),
//                        "The project description is NOT correct. Expecting " + description + ". But get " + sellerService.getProject(projectId, sellerId).getDescription());
//    }
//
//    @Test (dependsOnMethods = { "getProjectsTest" })
//    public void getOwnProjectTest() {
//        Long anotherSellerId = 2L;
//        Long anotherProjectId = 2L;
//        Project project2 = new Project();
//        populateProject(project2);
//        project2.setSellerId(2L);
//
//        sellerService.addProject(project2, anotherSellerId);
//        Assert.assertNull(sellerService.getProject(anotherProjectId, sellerId), "Sellers can get other sellers' project info! " + projectId + ".");
//    }

    // Integration test
    @Test (dependsOnMethods = { "getProjectsTest" })
    public void addProjectToSellerProjectList() {
        Map<Long, Seller> sellers = SellerTable.getSellers();
        System.out.println(sellers.get(sellerId).getProjectList().get(0).toString());
    }

    private void populateProject(Project project) {
        project.setDescription(description);
        project.setBudge(100.0);
//        project.setDueDate(LocalDate.now());
    }
}
